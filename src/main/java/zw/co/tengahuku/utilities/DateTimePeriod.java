package zw.co.tengahuku.utilities;

import java.beans.ConstructorProperties;
import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import javax.validation.constraints.NotNull;

public class DateTimePeriod implements Period<ZonedDateTime> {

	@Override
	public ZonedDateTime getFrom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ZonedDateTime getTo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFrom(ZonedDateTime var1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTo(ZonedDateTime var1) {
		// TODO Auto-generated method stub
		
	}
	/*
    private ZonedDateTime from;
    private ZonedDateTime to;

    public DateTimePeriod() {
    }

    @NotNull(
        message = "A DateTimePeriod from value must be provided"
    )
    public ZonedDateTime getFrom() {
        return this.from;
    }

    public void setFrom(ZonedDateTime from) {
        this.from = from;
    }

    @NotNull(
        message = "A DateTimePeriod to value must be provided"
    )
    public ZonedDateTime getTo() {
        return this.to;
    }

    public void setTo(ZonedDateTime to) {
        this.to = to;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DateTimePeriod)) {
            return false;
        } else {
            DateTimePeriod other = (DateTimePeriod)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$from = this.getFrom();
                Object other$from = other.getFrom();
                if (this$from == null) {
                    if (other$from != null) {
                        return false;
                    }
                } else if (!this$from.equals(other$from)) {
                    return false;
                }

                Object this$to = this.getTo();
                Object other$to = other.getTo();
                if (this$to == null) {
                    if (other$to != null) {
                        return false;
                    }
                } else if (!this$to.equals(other$to)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof DateTimePeriod;
    }

    public int hashCode() {
        int PRIME = true;
        int result = 1;
        Object $from = this.getFrom();
        int result = result * 59 + ($from == null ? 43 : $from.hashCode());
        Object $to = this.getTo();
        result = result * 59 + ($to == null ? 43 : $to.hashCode());
        return result;
    }

    public String toString() {
        return "DateTimePeriod(from=" + this.getFrom() + ", to=" + this.getTo() + ")";
    }

    @ConstructorProperties({"from", "to"})
    public DateTimePeriod(ZonedDateTime from, ZonedDateTime to) {
        this.from = from;
        this.to = to;
    }
    
    */
}
