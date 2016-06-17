/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable; 
import javax.persistence.AttributeOverride; 
import javax.persistence.AttributeOverrides; 
import javax.persistence.Column; 
import javax.persistence.Embedded; 
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType; 
import javax.persistence.Id; 
import javax.persistence.Table;

/**
 *
 * @author ek
 */
@Entity
@Table(name="book") 
public class Book implements Serializable{  
   private int id; 
   private String name; 
   private Publisher publisher;  
   
   public Book(){         
   }  
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
   
   public int getId() { 
      return id; 
   }
    public void setId(int id) { 
      this.id = id; 
   }  
   public String getName() { 
      return name; 
   }  
   public void setName(String name) { 
      this.name = name; 
   }   
   
   @Embedded 
   @AttributeOverrides({ 
      @AttributeOverride(name = "name",  
         column = @Column(name = "PUBLISHER")), 
      @AttributeOverride(name = "address",  
         column = @Column(name = "PUBLISHER_ADDRESS")) 
   }) 
   public Publisher getPublisher() { 
      return publisher; 
   }  
   public void setPublisher(Publisher publisher) { 
      this.publisher = publisher; 
   }     
}