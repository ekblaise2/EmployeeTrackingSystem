/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.query;

import entity.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
   @PersistenceContext(unitName="EJBQueryLanguagePU") 
   private EntityManager entityManager;  
     @Override
   public void addBook(Book book) { 
      entityManager.persist(book); 
   }      
     @Override
   public List<Book> getBooks() { 
      //create an ejbql expression 
      String ejbQL = "From Book b where b.name like ?1"; 
      //create query 
      Query query = entityManager.createQuery(ejbQL); 
      //substitute parameter. 
      query.setParameter(1, "%test%");    
      //execute the query 
      return query.getResultList(); 
   }  
}
