package database;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

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

    public LinkedList<Nouns> selectNouns(){
        LinkedList<Nouns> nounsLinkedList = new LinkedList<Nouns>();
        try{
            ResultSet rs = stmt.executeQuery("select * from nouns");
            int id;
            String plNoun, engNoun;
            while(rs.next()){
                id = rs.getInt("ID_nouns");
                plNoun = rs.getString("PL_nouns");
                engNoun = rs.getString("ENG_nouns");
                nounsLinkedList.add(new Nouns(id, plNoun, engNoun));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return nounsLinkedList;
    }
}
