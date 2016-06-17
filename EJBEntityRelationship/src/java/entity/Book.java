/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author ek
 */
@Entity 
@Table(name="booK") 
public class Book implements Serializable{  
   private int id; 
   private String name; 
   private Set<Author> authors;  
   public Book(){         
   }  
   @Id   
   @GeneratedValue(strategy= GenerationType.IDENTITY) 
   @Column(name="book_id") 
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
   public void setAuthors(Set<Author> authors) { 
      this.authors = authors; 
   }     
    
   @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE} 
      , fetch = FetchType.EAGER) 
   @JoinTable(
           name = "book_author", 
      joinColumns = @JoinColumn(name = "book_id"), 
      inverseJoinColumns = @JoinColumn(name = "author_id")
   ) 
   public Set<Author> getAuthors() 
   { 
      return authors; 
   } 
} 