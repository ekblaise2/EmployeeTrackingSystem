/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.intercception;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 *
 * @author ek
 */
@Interceptors ({BusinessInterceptor.class})
@Stateless
public class LibraryBean implements LibraryBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     List<String> bookShelf;      
   public LibraryBean(){ 
      bookShelf = new ArrayList<String>(); 
   }  
   public void addBook(String bookName) { 
      bookShelf.add(bookName); 
   }     
    public List<String> getBooks() { 
      return bookShelf; 
   } 
}
