/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.rela;

import entity.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ek
 */
@Stateless
public class LibraryPersistentBean implements LibraryPersistentBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     public LibraryPersistentBean(){ 
   }  
   @PersistenceContext(unitName="EJBEntityRelationshipPU") 
   private EntityManager entityManager;           
     @Override
   public void addBook(Book book) { 
      entityManager.persist(book); 
   }      
     @Override
   public List<Book> getBooks() { 
      return entityManager.createQuery("From Book").getResultList(); 
   } 
}
