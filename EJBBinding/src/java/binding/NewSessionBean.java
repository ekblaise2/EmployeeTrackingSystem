/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binding;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author ek
 */
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     List<String> bookShelf;     
    public NewSessionBean(){ 
       bookShelf = new ArrayList<String>(); 
    } 
    public void addBook(String bookName) { 
       bookShelf.add(bookName); 
    }     
  
    public List<String> getBooks() { 
        return bookShelf; 
    }
}
