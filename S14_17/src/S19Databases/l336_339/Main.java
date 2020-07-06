package S19Databases.l336_339;

import org.sqlite.JDBC;

import java.sql.*;

public class Main {
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Databases\\" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS "+TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS "+TABLE_CONTACTS+
                    " (_id INTEGER PRIMARY KEY, " +
                    COLUMN_NAME+" text, "+
                    COLUMN_PHONE+" text, "+
                    COLUMN_EMAIL+" text"+
                    ")");

            insertContact(statement, "Adriana", "456654", "adriana@mail.com");
            insertContact(statement, "Bobby", "123321", "bobby@mail.com");
            insertContact(statement, "Corina", "123321", "corina@mail.com");

            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " +
                    COLUMN_PHONE + "=789987" +
                    " WHERE " + COLUMN_NAME + "='Bobby'");

            statement.execute("DELETE FROM " +TABLE_CONTACTS +
                    " WHERE " + COLUMN_NAME + "='Corina'");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM "+TABLE_CONTACTS);

            while(resultSet.next()){
                System.out.print(resultSet.getInt("_id"));
                System.out.print(resultSet.getString(COLUMN_NAME));
                System.out.print(resultSet.getString(COLUMN_PHONE));
                System.out.println(resultSet.getString(COLUMN_EMAIL));
            }



            connection.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private static void insertContact(Statement statement, String name, String phone, String email) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " (" + COLUMN_NAME + ", " +
                COLUMN_PHONE + ", " +
                COLUMN_EMAIL +
                " ) " +
                "VALUES('" + name + "', " + phone + ", '" + email + "')");
    }
}
