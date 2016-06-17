/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entity.Book;

/**
 *
 * @author ek
 */
@Stateless
@WebService(serviceName="LibraryService") 
public class LibraryPersistentBean implements LibraryPersistentBeanRemote { 
     
   public LibraryPersistentBean(){ 
   }  
   @PersistenceContext(unitName="EJBWebServicesPU") 
   private EntityManager entityManager;           
   public void addBook(Book book) { 
      entityManager.persist(book); 
   }     
    
   @WebMethod(operationName="getBooks") 
   public List <Book> getBooks() { 
      return entityManager.createQuery("From Book").getResultList(); 
   } 
} 