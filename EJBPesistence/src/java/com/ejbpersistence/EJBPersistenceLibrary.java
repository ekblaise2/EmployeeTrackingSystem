/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ejbpersistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ek
 */
@Stateless
public class EJBPersistenceLibrary implements EJBPersistenceLibraryRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
        public EJBPersistenceLibrary(){
    
    
    }
    
    @PersistenceContext(unitName = "EJBPesistencePU")
    private EntityManager entityManager;
    
    @Override
    public void addBook(Books bookName) {
        
        entityManager.persist(bookName);
    }

    @Override
    public List<Books> getBooks() {
        
        entityManager.flush();
       return  entityManager.createQuery("SELECT name FROM Books name order by name.id").getResultList();
        
    }
}
