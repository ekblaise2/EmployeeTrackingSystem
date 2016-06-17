/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.callback;

import entity.Bookss;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

/**
 *
 * @author ek
 */
public class BookCallbackListener {
     @PrePersist 
   public void prePersist(Bookss book){ 
      System.out.println("BookCallbackListener.prePersist:"  
         + "Book to be created with book id: "+book.getId()); 
   }  
   @PostPersist 
   public void postPersist(Object book){ 
      System.out.println("BookCallbackListener.postPersist::" 
         + "Book created with book id: "+((Bookss)book).getId()); 
   }  
   @PreRemove 
   public void preRemove(Bookss book) 
   { 
      System.out.println("BookCallbackListener.preRemove:" 
         + " About to delete Book: " + book.getId()); 
   }  
   @PostRemove 
   public void postRemove(Bookss book) 
   { 
      System.out.println("BookCallbackListener.postRemove::" 
         + " Deleted Book: " + book.getId()); 
   }  
   @PreUpdate 
   public void preUpdate(Bookss book) 
   { 
      System.out.println("BookCallbackListener.preUpdate::" 
         + " About to update Book: " + book.getId()); 
   }  
   @PostUpdate 
   public void postUpdate(Bookss book)  { 
      System.out.println("BookCallbackListener.postUpdate::" 
         + " Updated Book: " + book.getId()); 
   }  
   @PostLoad 
   public void postLoad(Bookss book) 
   { 
      System.out.println("BookCallbackListener.postLoad::" 
         + " Loaded Book: " + book.getId()); 
   }
}
