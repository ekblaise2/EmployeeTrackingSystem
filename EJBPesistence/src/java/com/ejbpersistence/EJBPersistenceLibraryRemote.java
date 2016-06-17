/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ejbpersistence;

//import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

/**
 *
 * @author ek
 */
@Remote
public interface EJBPersistenceLibraryRemote {
    void addBook(Books bookName);
    
    List<Books> getBooks(); 
}
