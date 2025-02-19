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

    public void insertResult(int score){
        String sqlResult = "insert into results values (NULL, "+score+");";
        try{
            stmt.execute(sqlResult);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void showResults(){
        int id, score;
        try{
            ResultSet rs = stmt.executeQuery("SELECT * FROM results;");
            while (rs.next()){
                id = rs.getInt(1);
                score = rs.getInt(2);
                System.out.println("ID: "+id+"\tSCORE: "+score+"/7");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Verbs putVerb(int id){

        Verbs someVerb = null;
        try{
            String pl1, pl2, eng1, eng2;
            ResultSet rs = stmt.executeQuery("SELECT * FROM verbs WHERE id_verbs ="+id+";");

            rs.next();
            pl1 = rs.getString(2);
            pl2 = rs.getString(3);
            eng1 = rs.getString(4);
            eng2 = rs.getString(5);

           someVerb = new Verbs(id, pl1, pl2, eng1, eng2);

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return someVerb;
    }


    public LinkedList<Verbs> selectVerbs(){
        LinkedList<Verbs> verbsLinkedList = new LinkedList<>();
        try{
            ResultSet rs = stmt.executeQuery("SELECT * FROM verbs");
            int idVerb;
            String plVerb1, plVerb2, plVerb3, engVerb1, engVerb2, engVerb3;
            while (rs.next()){
                idVerb = rs.getInt(1);
                plVerb1 = rs.getString(2);
                plVerb2 = rs.getString(3);
                engVerb1 = rs.getString(4);
                engVerb2 = rs.getString(5);
                verbsLinkedList.add(new Verbs(idVerb,plVerb1,plVerb2,engVerb1,engVerb2));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return verbsLinkedList;
    }

    public void resetID(String categoryName){
        String deleteString = "alter table "+categoryName+" drop column id_verbs;";
        String addString = "alter table "+categoryName+" add column id_verbs int primary key not null auto_increment first;";

        try{
            stmt.execute(deleteString);
            stmt.execute(addString);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean insertNoun(String pl, String eng){
        try{String sqlString = "insert into nouns values"+
                "(NULL, '"+pl+"', '"+eng+"');";
        stmt.execute(sqlString);
        return true;
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertVerb(String pl1, String pl2, String eng1, String eng2){
        String sqlString = "insert into verbs values"+
                "(NULL, '"+pl1+"', '"+pl2+"', '"+eng1+"', '"+eng2+"');";
        try{
            stmt.execute(sqlString);
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public int getLastId(String categoryName){
        int lastID = 0;

        try{
            ResultSet rs = stmt.executeQuery("SELECT * from "+categoryName+";");
            while(rs.next()){
                lastID++;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return lastID;
    }

    public void updateRecord(int recordID, String categoryName, String pl1, String pl2, String eng1, String eng2){
        String sqlString = "update "+categoryName+" set pl_verbs1='"+pl1+"', pl_verbs2='"+pl2+"', eng_verbs1='"+eng1+
                "', eng_verbs2='"+eng2+"' where id_verbs="+recordID+";";

        try{
            stmt.execute(sqlString);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteRecord(int recordID, String categoryName){
        String sqlString = "delete from "+categoryName+" where id_verbs="+recordID+";";

        try{
            stmt.execute(sqlString);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

}
