package student.management.system;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;


public class JdbcConn {
    Connection c;
    Statement s;
    JdbcConn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem","root","Sameer@2001");
            s=c.createStatement();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
