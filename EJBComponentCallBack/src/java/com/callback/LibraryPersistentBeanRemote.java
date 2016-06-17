/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.callback;

import java.util.List;
import javax.ejb.Remote;
import entity.Bookss;

/**
 *
 * @author ek
 */
@Remote
public interface LibraryPersistentBeanRemote {
       void addBook(Bookss bookName);  
     List<Bookss> getBooks();
}
