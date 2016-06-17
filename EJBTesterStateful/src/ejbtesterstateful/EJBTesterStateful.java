/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejbtesterstateful;

//import com.sessions.LibraryStatefulSessionBeanRemote;
import com.sessions.LibraryStatefulSessionBeanRemote;
//import java.awt.print.Book;
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
public class EJBTesterStateful {

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
  
      EJBTesterStateful ejbTester = new EJBTesterStateful(); 
  
      ejbTester.testStatelessEjb(); 
   } 
    
   private void showGUI(){ 
      System.out.println("**********************"); 
      System.out.println("Welcome to Book Store"); 
      System.out.println("**********************"); 
      System.out.print("Options \n1. Add Book\n2. Exit \nEnter Choice: "); 
   } 
    
   private void testStatelessEjb(){ 

      try { 
         int choice = 1;  
  
          LibraryStatefulSessionBeanRemote libraryBean = 
                     (LibraryStatefulSessionBeanRemote) context.lookup("java:global/LibraryStatefulSessionBeans/LibraryStatefulSessionBean");
         
         while (choice != 2) { 
            String bookName; 
            showGUI(); 
            String strChoice = brConsoleReader.readLine(); 
            choice = Integer.parseInt(strChoice); 
            if (choice == 1) { 
               System.out.print("Enter book name: "); 
               bookName = brConsoleReader.readLine(); 
               Book book = new Book(); 
               book.setName(bookName); 
               libraryBean.addBook(bookName);           
            } else if (choice == 2) { 
               break; 
            } 
         } 
  
         List<Book> booksList = libraryBean.getBooks(); 
  
         System.out.println("Book(s) entered so far: " + booksList.size()); 
         int i = 0; 
//         for (Book book:booksList) { 
//            System.out.println((i+1)+". " + book.getName()); 
//            i++; 
//         } 
         for(i = 0 ; i < booksList.size(); ++i){
                System.out.println((i+1) + "."+ booksList.get(i));
            }
        LibraryStatefulSessionBeanRemote libraryBean1 
                     = (LibraryStatefulSessionBeanRemote) context.lookup("java:global/LibraryStatefulSessionBeans/LibraryStatefulSessionBean");
   
         List<String> booksList1 = libraryBean1.getBooks(); 
         System.out.println( 
            "***Using second lookup to get library stateful object***"); 
         System.out.println( 
            "Book(s) entered so far: " + booksList1.size()); 
         for ( i = 0; i < booksList1.size(); ++i) { 
            System.out.println((i+1)+". " + booksList1.get(i)); 
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
