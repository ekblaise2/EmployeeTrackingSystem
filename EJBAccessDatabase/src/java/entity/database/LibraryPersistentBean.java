/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.database;

import entity.Book;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author ek
 */
@Stateless
public class LibraryPersistentBean implements LibraryPersistentBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     public LibraryPersistentBean(){ 
   }
     @Override
      public void addBook(Book book) { 
      Connection con = null; 
      String url = "jdbc:postgresql://localhost:5432/postgres"; 
      String driver = "org.postgresql.driver";  
      String userName = "sa"; 
      String password = "sa"; 
      List<Book> books = new ArrayList<>(); 
      try {  
         Class.forName(driver).newInstance(); 
         con = DriverManager.getConnection(url , userName, password);  
         PreparedStatement st =  
         con.prepareStatement("insert into books(name) values(book.getName())"); 
         st.setString(1,book.getName());  
         int result = st.executeUpdate();                  
      } catch (SQLException ex) { 
         ex.printStackTrace(); 
      } catch (InstantiationException ex) { 
         ex.printStackTrace(); 
      } catch (IllegalAccessException ex) { 
         ex.printStackTrace(); 
      } catch (ClassNotFoundException ex) { 
         ex.printStackTrace(); 
      }     
   }      
     @Override
   public List<Book> getBooks() { 
      Connection con = null; 
      String url = "jdbc:postgresql://localhost:5432/postgres"; 
      String driver = "org.postgresql.driver"; 
       String userName = "sa"; 
      String password = "sa"; 
      List<Book> books = new ArrayList<Book>(); 
      try {  
         Class.forName(driver).newInstance(); 
         con = DriverManager.getConnection(url , userName, password);  
          java.sql.Statement st = con.createStatement(); 
         ResultSet rs = st.executeQuery("select * from books");  
         Book book; 
         while (rs.next()) { 
            book = new Book(); 
            book.setId(rs.getInt(1));                  
            book.setName(rs.getString(2)); 
            books.add(book); 
         } 
      } catch (SQLException ex) { 
         ex.printStackTrace(); 
      } catch (InstantiationException ex) { 
         ex.printStackTrace(); 
      } catch (IllegalAccessException ex) { 
         ex.printStackTrace(); 
      } catch (ClassNotFoundException ex) { 
         ex.printStackTrace(); 
      } 
      return books; 
   }
}
