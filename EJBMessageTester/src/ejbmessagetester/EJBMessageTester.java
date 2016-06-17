/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejbmessagetester;

import com.ejbpersistence.Books; 
import com.ejbpersistence.EJBPersistenceLibraryRemote; 
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.List; 
import javax.jms.ObjectMessage; 
import javax.jms.Queue; 
import javax.jms.QueueConnection; 
import javax.jms.QueueConnectionFactory; 
import javax.jms.QueueSender; 
import javax.jms.QueueSession; 
import javax.naming.InitialContext; 
import javax.naming.NamingException;
/**
 *
 * @author ek
 */
public class EJBMessageTester {

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
     EJBMessageTester ejbTester = new EJBMessageTester(); 
  
      ejbTester.testMessageBeanEjb();
    }
    
     private void showGUI(){ 
      System.out.println("**********************"); 
      System.out.println("Welcome to Book Store"); 
      System.out.println("**********************"); 
      System.out.print("Options \n1. Add Book\n2. Exit \nEnter Choice: "); 
   } 
    
   private void testMessageBeanEjb(){ 
  
      try { 
         int choice = 1;  
         Queue queue = (Queue) context.lookup("jms/dest"); 
         QueueConnectionFactory factory =  (QueueConnectionFactory) context.lookup("TestQueueConnectionFactory"); 
         QueueConnection connection =  factory.createQueueConnection(); 
         QueueSession session =  connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE); 
         QueueSender sender = session.createSender(queue); 
  
         while (choice != 2) { 
            String bookName; 
            showGUI(); 
            String strChoice = brConsoleReader.readLine(); 
            choice = Integer.parseInt(strChoice); 
            if (choice == 1) { 
               System.out.print("Enter book name: "); 
               bookName = brConsoleReader.readLine(); 
               Books book = new Books(); 
               book.setName(bookName); 
               ObjectMessage objectMessage =  
                  session.createObjectMessage(book); 
               sender.send(objectMessage);  
            } else if (choice == 2) { 
               break; 
            } 
         } 
  
          EJBPersistenceLibraryRemote libraryBean 
                  = (EJBPersistenceLibraryRemote) context.lookup("java:global/EJBPesistence/EJBPersistenceLibrary!com.ejbpersistence.EJBPersistenceLibraryRemote");

         List<Books> booksList = libraryBean.getBooks(); 
  
         System.out.println("Book(s) entered so far: " + booksList.size()); 
         int i = 0; 
         for (Books book:booksList) { 
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
