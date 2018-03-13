package zw.co.tengahuku.payload.inbound;

import zw.co.tengahuku.utilities.ToStringResolver;

public interface Payload  extends ToStringResolver{
	
	default String resolveToString(Object... objects) {
        return this.resolveToStringMessage(objects);
    }

}
