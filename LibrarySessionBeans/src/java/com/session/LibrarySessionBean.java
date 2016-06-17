/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.session;

import javax.ejb.Stateless;
import java.util.ArrayList; 
import java.util.List; 

/**
 *
 * @author ek
 */
@Stateless
public class LibrarySessionBean implements LibrarySessionBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
        List<String> bookShelf;     
     public LibrarySessionBean(){ 
       bookShelf = new ArrayList<String>(); 
    } 
     
    public void addBook(String bookName) { 
        bookShelf.add(bookName); 
    }     
  
    public List<String> getBooks() { 
        return bookShelf; 
    }
}
