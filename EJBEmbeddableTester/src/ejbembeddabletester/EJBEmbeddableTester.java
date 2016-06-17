/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejbembeddabletester;

import embeddedableobjects.LibraryPersistentBeanRemote;
import entity.Book;
import entity.Publisher;
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
public class EJBEmbeddableTester {

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
         EJBEmbeddableTester ejbTester = new EJBEmbeddableTester();  
             ejbTester.testEmbeddedObjects();
    }
     private void showGUI(){ 
      System.out.println("**********************"); 
      System.out.println("Welcome to Book Store"); 
      System.out.println("**********************"); 
      System.out.print("Options \n1. Add Book\n2. Exit \nEnter Choice: "); 
   } 
    
   private void testEmbeddedObjects(){  
      try { 
         int choice = 1;   
         LibraryPersistentBeanRemote libraryBean =  
        (LibraryPersistentBeanRemote) 
         context.lookup("java:global/EJBEmbeddableObjects/LibraryPersistentBean!embeddedableobjects.LibraryPersistentBeanRemote");  
         while (choice != 2) { 
            String bookName; 
            String publisherName; 
            String publisherAddress; 
            showGUI(); 
            String strChoice = brConsoleReader.readLine(); 
            choice = Integer.parseInt(strChoice); 
            if (choice == 1) { 
               System.out.print("Enter book name: "); 
               bookName = brConsoleReader.readLine(); 
                System.out.print("Enter publisher name: "); 
               publisherName = brConsoleReader.readLine(); 
               System.out.print("Enter publisher address: "); 
               publisherAddress = brConsoleReader.readLine(); 
               Book book = new Book(); 
               book.setName(bookName); 
               book.setPublisher 
              (new Publisher(publisherName,publisherAddress));  
               libraryBean.addBook(book);           
            } else if (choice == 2) { 
               break; 
            } 
         }  
         List<Book> booksList = libraryBean.getBooks();  
         System.out.println("Book(s) entered so far: " + booksList.size()); 
         int i = 0; 
         for (Book book:booksList) { 
            System.out.println((i+1)+". " + book.getName()); 
            System.out.println("Publication: "+book.getPublisher()); 
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
