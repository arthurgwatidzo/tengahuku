package zw.co.tengahuku.utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface ToStringResolver {
	String resolveToString(Object... var1);

    default String resolveToStringMessage(Object... objects) {
        String className = this.getClass().getSimpleName();
        StringBuilder builder = new StringBuilder(className);
        builder.append("(");
        this.addObjects(this.mergeList(objects), builder);
        builder.append(")");
        return builder.toString();
    }

    default void addObjects(Object[] objects, StringBuilder builder) {
        int entries = objects.length / 2;
        boolean allNull = true;

        for(int i = 0; i < entries; ++i) {
            String key = (String)objects[i * 2];
            Object value = objects[i * 2 + 1];
            if (!this.emptyValue(value)) {
                allNull = false;
                builder.append(key);
                builder.append("=");
                builder.append(this.resolveValue(value));
                builder.append(", ");
            }
        }

        if (!allNull) {
            this.removeLastComma(builder);
        }

    }

    default String resolveValue(Object value) {
        if (value instanceof BaseEntity) {
            return String.valueOf(((BaseEntity)value).getId());
        } else {
            return value instanceof List ? this.resolveListToString((List)value) : value.toString();
        }
    }

    default String resolveListToString(List list) {
        StringBuilder builder = new StringBuilder("[");
        Iterator var3 = list.iterator();

        while(var3.hasNext()) {
            Object item = var3.next();
            String value = item.toString() == null ? "null" : item.toString();
            builder.append(value);
            builder.append(", ");
        }

        this.removeLastComma(builder);
        builder.append("]");
        return builder.toString();
    }

    default void removeLastComma(StringBuilder builder) {
        builder.setLength(builder.length() - 2);
    }

    default boolean emptyValue(Object value) {
        return value == null || value instanceof List && ((List)value).isEmpty();
    }

    default Object[] mergeList(Object... objects) {
        List<Object> mergedList = new ArrayList();
        this.recursivelyMerge(mergedList, objects);
        return mergedList.toArray();
    }

    default void recursivelyMerge(List<Object> mergedList, Object[] objects) {
        Object[] var3 = objects;
        int var4 = objects.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Object obj = var3[var5];
            if (obj instanceof Object[]) {
                this.recursivelyMerge(mergedList, (Object[])((Object[])obj));
            } else {
                mergedList.add(obj);
            }
        }

    }
}
