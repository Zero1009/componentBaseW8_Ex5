/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentbasew8_ex5;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Theerakan
 */
public class ComponentBaseW8_Ex5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws ClassNotFoundException, SQLException  {
        String derbyClientDriver = "org.apache.derby.jdbc.ClientDriver";
        Class.forName(derbyClientDriver);
        String url = "jdbc:derby://localhost:1527/student";
        String user = "app";
        String passwd = "app";
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement stmt = con.createStatement();
        Student std = new Student(1, "Padkapao", 4.00);
        insertStudent(stmt, std);
        stmt.close();
        con.close();
    }
    
    public static void insertStudent(Statement stmt, Student std) throws SQLException {
       /*String sql = "insert into employee (id, name, salary)" +
                     " values (5, 'Mark', 12345)";*/
        String sql = "insert into student (id, name, gpa)" +
                     " values (" + std.getId() + "," + "'" + std.getName() + "'" + "," + std.getGpa() + ")";
        int result = stmt.executeUpdate(sql);
        System.out.println("Insert " + result + " row");
   } 
   
    public static void deleteStudent(Statement stmt, Student std) throws SQLException {
       String sql = "delete from student where id = " + std.getId();
       int result = stmt.executeUpdate(sql);
        //display result
        System.out.println("delete " + result + " row");
   }
    
      public static void updateStudentGpa(Statement stmt, Student std) throws SQLException {
       String sql = "update student set gpa  = " + std.getGpa() + 
               " where id = " + std.getId();
       int result = stmt.executeUpdate(sql);
        //display result
        System.out.println("update " + result + " row");
   }
   public static void updateStudentName(Statement stmt, Student std) throws SQLException {
       String sql = "update student set name  = '" + std.getName() + "'" + 
               " where id = " + std.getId();
       int result = stmt.executeUpdate(sql);
        //display result
        System.out.println("update " + result + " row");
   }
   
    
}
