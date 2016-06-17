/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejbtester;

import com.session.LibrarySessionBeanRemote;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author ek
 */
public class EJBTester {

    /**
     * @param args the command line arguments
     */
   BufferedReader brConsoleReader = null; 
 //  Properties props;
   InitialContext context;
   {
  //    props = new Properties();
      //props = new Properties();

  //    props.put("java.naming.factory.initial",
  //                "com.sun.jndi.cosnaming.CNCtxFactory"
   //   );
//      props.put("java.naming.factory.url.pkgs","http-remoting://localhost:7070");
 //         props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
 //         props.put("java.naming.factory.url.pkgs",
    //                "com.sun.enterprise.naming");
//      props.put("java.naming.provider.url", "remote://localhost:7070");
 //     props.put(InitialContext.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
//      props.setProperty("java.naming.factory.state",
  //                  "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
//            props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
//            props.put(Context.PROVIDER_URL,"remote://127.0.0.1:4447");
//            // username
//            props.put(Context.SECURITY_PRINCIPAL, "user");
//            // password
//            props.put(Context.SECURITY_CREDENTIALS, "password");
//            // This is an important property to set if you want to do EJB invocations via the remote-naming project
//            props.put("jboss.naming.client.ejb.context", true);
//            props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");  
//            props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");  
//            props.put(Context.PROVIDER_URL,"jnp://localhost:7070"); 
//      try {
//      props.load(new FileInputStream("jndi.properties"));
//      } catch (IOException ex) {
//      ex.printStackTrace();
//      }
//      try {
//      ctx = new InitialContext(props);            
//      } catch (NamingException ex) {
//      ex.printStackTrace();
//      }
      //code snipet for glashfish
     
        try {
            context = new InitialContext();
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
//      LibrarySessionBeanRemote ejbBean = (LibrarySessionBeanRemote) context.lookup("java:global/DeployedEJBAppName/EjbImplClass!com.sam._RemoteEjbInterface");
      brConsoleReader = 
      new BufferedReader(new InputStreamReader(System.in));
   }
   public static void main(String[] args) {
 
      EJBTester ejbTester = new EJBTester();
 
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
//            LibrarySessionBeanRemote libraryBean
//                    = (LibrarySessionBeanRemote )ctx.lookup("java:global/LibrarySessionBeans/LibrarySessionBean!com.session.LibrarySessionBeanRemote, java:global/LibrarySessionBeans/LibrarySessionBean");
             LibrarySessionBeanRemote libraryBean = 
                     (LibrarySessionBeanRemote) context.lookup("java:global/LibrarySessionBeans/LibrarySessionBean");
            while (choice != 2) {
                String bookName;
                showGUI();
                String strChoice = brConsoleReader.readLine();
                choice = Integer.parseInt(strChoice);
                if (choice == 1) {
                    System.out.print("Enter book name: ");
                    bookName = brConsoleReader.readLine();
                    libraryBean.addBook(bookName);
                } else if (choice == 2) {
                    break;
                }
            }
            List<String> booksList = libraryBean.getBooks();
            System.out.println("Book(s) entered so far: " + booksList.size());
            for(int i = 0 ; i < booksList.size(); ++i){
                System.out.println((i+1) + "."+ booksList.get(i));
            }
//            LibrarySessionBeanRemote libraryBean1
//                    = (LibrarySessionBeanRemote) ctx.lookup("java:global/LibrarySessionBeans/LibrarySessionBean!com.session.LibrarySessionBeanRemote, java:global/LibrarySessionBeans/LibrarySessionBean");
              LibrarySessionBeanRemote libraryBean1 
                      = (LibrarySessionBeanRemote) context.lookup("java:global/LibrarySessionBeans/LibrarySessionBean");
          
            List<String> booksList1 = libraryBean1.getBooks();
            System.out.println(
                    "***Using second lookup to get library stateful object***");
            System.out.println(
                    "Book(s) entered so far: " + booksList1.size());
            for (int i = 0; i < booksList1.size(); ++i) {
                System.out.println((i + 1) + ". " + booksList1.get(i));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (brConsoleReader != null) {
                    brConsoleReader.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
   } 
}
