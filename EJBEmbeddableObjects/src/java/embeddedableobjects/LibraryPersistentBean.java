/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package embeddedableobjects;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entity.Book;

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
     
   @PersistenceContext(unitName="EJBEmbeddableObjectsPU") 
   private EntityManager entityManager;  
   
     @Override
   public void addBook(Book book) { 
      entityManager.persist(book); 
   }    
   
     @Override
   public List<Book> getBooks() { 
       entityManager.flush();
      return entityManager.createQuery("SELECT name FROM Book name order by name.id").getResultList(); 
   } 
 
}
