/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejbtimertester;

import com.timer.TimerSessionBeanRemote;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author ek
 */
public class EJBTimerTester {

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
        EJBTimerTester ejbTester = new EJBTimerTester();  
      ejbTester.testTimerService();
    }
     private void showGUI(){ 
      System.out.println("**********************"); 
      System.out.println("Welcome to Book Store"); 
      System.out.println("**********************"); 
      System.out.print("Options \n1. Add Book\n2. Exit \nEnter Choice: "); 
   } 
    
   private void testTimerService(){ 
      try { 
         TimerSessionBeanRemote timerServiceBean = (TimerSessionBeanRemote)context.lookup("java:global/EJBTimerLibrary/TimerSessionBean!com.timer.TimerSessionBeanRemote");  
         System.out.println("["+(new Date()).toString()+ "]" + "timer created."); 
         timerServiceBean.createTimer(2000);              
      } catch (NamingException ex) { 
         ex.printStackTrace(); 
      } 
   } 
    
}
