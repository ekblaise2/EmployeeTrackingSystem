/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejbtesterstateful;

/**
 *
 * @author ek
 */
public class Book {
    private String bookName;

 public void setName(String bookName) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.bookName = bookName;
    }

  public  String getName() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         return bookName;
    }
    
}
