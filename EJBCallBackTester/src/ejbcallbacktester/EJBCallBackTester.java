/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejbcallbacktester;

import com.callback.LibraryPersistentBeanRemote;
import com.callback.LibraryStatefulSessionBeanRemote;
import entity.Bookss;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author ek
 */
public class EJBCallBackTester {

    /**
     * @param args the command line arguments
     */
     BufferedReader brConsoleReader = null;  
  // Properties props; 
   InitialContext context; 
   { 
       try {
            context = new InitialContext();
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
      brConsoleReader = 
      new BufferedReader(new InputStreamReader(System.in));
   } 
    public static void main(String[] args) {
        // TODO code application logic here
        EJBCallBackTester ejbTester = new EJBCallBackTester(); 
  
      ejbTester.testEntityEjb(); 
    }
    
     private void showGUI(){ 
      System.out.println("**********************"); 
      System.out.println("Welcome to Book Store"); 
      System.out.println("**********************"); 
      System.out.print("Options \n1. Add Book\n2. Exit \nEnter Choice: "); 
   } 
    
   private void testEntityEjb(){     
      try { 
      int choice = 1;   
      LibraryPersistentBeanRemote libraryBean =  
      (LibraryPersistentBeanRemote) 
      context.lookup("java:global/EJBComponentCallBack/LibraryStatefulSessionBean!com.callback.LibraryStatefulSessionBeanRemote");  
      while (choice != 2) { 
         String bookName; 
         showGUI(); 
         String strChoice = brConsoleReader.readLine(); 
         choice = Integer.parseInt(strChoice); 
         if (choice == 1) { 
            System.out.print("Enter book name: "); 
            bookName = brConsoleReader.readLine(); 
            Bookss book = new Bookss(); 
            book.setName(bookName); 
            libraryBean.addBook(book);           
         } else if (choice == 2) { 
            break; 
         } 
      }  
      List<Bookss> booksList = libraryBean.getBooks(); 
       System.out.println("Book(s) entered so far: " + booksList.size()); 
      int i = 0; 
      for (Bookss book:booksList) { 
         System.out.println((i+1)+". " + book.getName()); 
         i++; 
      }             
      } catch (Exception e) { 
         System.out.println(e.getMessage()); 
         e.printStackTrace(); 
      }finally { 
         try { 
            if(brConsoleReader !=null){ 
               brConsoleReader.close(); 
            } 
         } catch (IOException ex) { 
            System.out.println(ex.getMessage()); 
         } 
      }     
   }     
    
}
