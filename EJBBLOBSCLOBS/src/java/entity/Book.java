/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

//import javax.persistence.EntityListeners; 

/**
 *
 * @author ek
 */
@Entity
@Table(name="bookss")
public class Book implements Serializable {
   private int id; 
   private String name;     
   private byte[] image;    
   private String xml;  
   public Book(){         
   }  
   
   @Id 
   @GeneratedValue(strategy= GenerationType.IDENTITY) 
   @Column(name="id") 
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
   @Lob @Basic(fetch= FetchType.EAGER) 
   public byte[] getImage() { 
      return image; 
   }  
   public void setImage(byte[] image) { 
      this.image = image; 
   } 
    @Lob @Basic(fetch= FetchType.EAGER) 
   public String getXml() { 
      return xml; 
   }  
   public void setXml(String xml) { 
      this.xml = xml; 
   } 
}
