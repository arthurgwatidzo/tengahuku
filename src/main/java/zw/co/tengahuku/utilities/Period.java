package zw.co.tengahuku.utilities;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public interface Period<T> extends Serializable {
    T getFrom();

    T getTo();

    void setFrom(T var1);

    void setTo(T var1);
}

