package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Lexicon {

    private Connection conn;
    private Statement stmt;

    public Lexicon(){
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sevensecond?autoReconnect=true&useSSL=false","root","close3");
            stmt = conn.createStatement();
        }
        catch (SQLException e){
            System.out.println("Not connected..");
            e.printStackTrace();
        }

    }

    public boolean createTables(String tableName){
        try{
            stmt.execute("create table if not exists "+tableName+"(id int primary key auto_increment," +
                    "wordPL char(20) default 'word', wordENG char(20) default 'word');");
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return  true;
    }
}
