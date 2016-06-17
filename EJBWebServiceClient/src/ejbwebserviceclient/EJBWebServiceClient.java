/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejbwebserviceclient;

/**
 *
 * @author ek
 */
public class EJBWebServiceClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         for(Book book:getBooks()){ 
         System.out.println(book.getName()); 
      }
    }

    private static java.util.List<ejbwebserviceclient.Book> getBooks() {
        ejbwebserviceclient.LibraryService service = new ejbwebserviceclient.LibraryService();
        ejbwebserviceclient.LibraryPersistentBean port = service.getLibraryPersistentBeanPort();
        return port.getBooks();
    }
        
}
