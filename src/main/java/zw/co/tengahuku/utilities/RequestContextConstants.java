package zw.co.tengahuku.utilities;

public enum RequestContextConstants {
	USER_ID("User-Id"),
    SYSTEM_USER_ID("System-User-Id"),
    CORRELATION_ID("Correlation-Id"),
    SESSION_ID("Session-Id"),
    MESSAGE_ID("Message-Id"),
    TRANSACTION_ID("Transaction-Id"),
    TENANT("Tenant-Id"),
    LOCALE("Locale");

    private String property;

    private RequestContextConstants(String property) {
        this.property = property;
    }

    public String getProperty() {
        return this.property;
    }

    public static RequestContextConstants getRequestContextConstant(String property) {
        String var1 = property.toLowerCase();
        byte var2 = -1;
        switch(var1.hashCode()) {
        case -1852828386:
            if (var1.equals("tenant-id")) {
                var2 = 6;
            }
            break;
        case -1690770271:
            if (var1.equals("message-id")) {
                var2 = 4;
            }
            break;
        case -1097462182:
            if (var1.equals("locale")) {
                var2 = 7;
            }
            break;
        case -622204737:
            if (var1.equals("system-user-id")) {
                var2 = 1;
            }
            break;
        case -147180963:
            if (var1.equals("user-id")) {
                var2 = 0;
            }
            break;
        case 1010536042:
            if (var1.equals("transaction-id")) {
                var2 = 5;
            }
            break;
        case 1661805490:
            if (var1.equals("session-id")) {
                var2 = 3;
            }
            break;
        case 2055280966:
            if (var1.equals("correlation-id")) {
                var2 = 2;
            }
        }

        switch(var2) {
        case 0:
            return USER_ID;
        case 1:
            return SYSTEM_USER_ID;
        case 2:
            return CORRELATION_ID;
        case 3:
            return SESSION_ID;
        case 4:
            return MESSAGE_ID;
        case 5:
            return TRANSACTION_ID;
        case 6:
            return TENANT;
        case 7:
            return LOCALE;
        default:
            return null;
        }
    }

}
