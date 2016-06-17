/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blob.clob;

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
   @PersistenceContext(unitName="EJBBLOBSCLOBSPU") 
   private EntityManager entityManager;           
   public void addBook(Book book) { 
      entityManager.persist(book); 
   }      
   public List<Book> getBooks() { 
      return entityManager.createQuery("From Book").getResultList(); 
   }
}
