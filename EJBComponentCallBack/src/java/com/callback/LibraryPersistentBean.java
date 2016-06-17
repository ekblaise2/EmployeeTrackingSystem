/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.callback;

import entity.Bookss;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ek
 */
@Stateless
public class LibraryPersistentBean implements LibraryPersistentBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     public LibraryPersistentBean(){}  
   @PersistenceContext(unitName="EJBPesistencePU") 
   private EntityManager entityManager;     
    public void addBook(Bookss book) { 
      entityManager.persist(book); 
   }      
   public List<Bookss> getBooks() {      
      return entityManager.createQuery("From Book") 
         .getResultList(); 
   }  
   @PostConstruct 
   public void postConstruct(){ 
      System.out.println("postConstruct:: LibraryPersistentBean session bean" 
         + " created with entity Manager object: "); 
   }  
   @PreDestroy 
   public void preDestroy(){ 
      System.out.println("preDestroy: LibraryPersistentBean session" 
      + " bean is removed "); 
   } 
}
