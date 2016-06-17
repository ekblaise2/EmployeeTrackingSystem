/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejbblobclobtester;

import blob.clob.LibraryPersistentBeanRemote;
import entity.Book;
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
public class EJBBlobClobTester {

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
        EJBBlobClobTester ejbTester = new EJBBlobClobTester(); 
  
      ejbTester.testBlobClob(); 
    }
     private void showGUI(){ 
      System.out.println("**********************"); 
      System.out.println("Welcome to Book Store"); 
      System.out.println("**********************"); 
      System.out.print("Options \n1. Add Book\n2. Exit \nEnter Choice: "); 
   } 
    
   private void testBlobClob(){  
      try { 
         int choice = 1;   
         LibraryPersistentBeanRemote libraryBean =  
        (LibraryPersistentBeanRemote)  context.lookup("java:global/EJBBLOBSCLOBS/LibraryPersistentBean!blob.clob.LibraryPersistentBeanRemote");  
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
               String xml = "<book><name>"+bookName+"</name></book>"; 
               Book book = new Book(); 
               book.setName(bookName);                                         
               byte[] imageBytes = {0x32, 0x32,0x32, 0x32,0x32, 
               0x32,0x32, 0x32, 
               0x32, 0x32,0x32, 0x32,0x32, 0x32,0x32, 0x32, 
               0x32, 0x32,0x32, 0x32,0x32, 0x32,0x32, 0x32 
               }; 
               book.setImage(imageBytes); 
               book.setXml(xml);  
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
            byte[] imageByts = book.getImage(); 
             if(imageByts != null){ 
               System.out.print("image bytes: ["); 
               for(int j = 0; j < imageByts.length ; j++){ 
                  System.out.print("0x"  
                  + String.format("%x", imageByts[j]) +" "); 
               }             
               System.out.println("]"); 
            }         
            System.out.println(book.getXml()); 
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
