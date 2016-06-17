/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.injection;

import com.ejbpersistence.Books;
import com.ejbpersistence.EJBPersistenceLibraryRemote;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author ek
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/dest")
})
public class LibraryMessageBean implements MessageListener {
    
    public LibraryMessageBean() {
    }
    
    @Override
    public void onMessage(Message message) {
          ObjectMessage objectMessage = null; 
      try { 
         objectMessage = (ObjectMessage) message; 
         Books book = (Books) objectMessage.getObject();  
         libraryBean.addBook(book); 
  
      } catch (JMSException ex) { 
         mdctx.setRollbackOnly(); 
      } 
    }
     @Resource 
   private MessageDrivenContext mdctx;   
  
   @EJB 
   EJBPersistenceLibraryRemote libraryBean; 
   
}
