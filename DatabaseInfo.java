package RMI;


public interface DatabaseInfo {
    public static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String dbURL="jdbc:sqlserver://localhost:1433;databaseName=QL_NV;integratedSecurity=true;";
    public static String userDB="";
    public static String passDB="";
}
