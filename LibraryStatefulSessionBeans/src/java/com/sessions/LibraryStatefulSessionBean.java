/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sessions;

import javax.ejb.Stateful;
import java.util.ArrayList; 
import java.util.List; 
import javax.ejb.Stateful;

/**
 *
 * @author ek
 */
@Stateful
public class LibraryStatefulSessionBean implements LibraryStatefulSessionBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     List<String> bookShelf;     
  
   public LibraryStatefulSessionBean(){ 
      bookShelf = new ArrayList<String>(); 
   } 
  
   public void addBook(String bookName) { 
      bookShelf.add(bookName); 
   }     
  
   public List<String> getBooks() { 
      return bookShelf; 
   }
}
