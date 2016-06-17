/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.timer;

import java.util.Date;
import javax.ejb.Schedule;
import javax.annotation.Resource; 
import javax.ejb.SessionContext; 
import javax.ejb.Timer; 
import javax.ejb.Stateless; 
import javax.ejb.Timeout;

/**
 *
 * @author ek
 */
@Stateless
public class TimerSessionBean implements TimerSessionBeanRemote {

    @Schedule(minute = "*", second = "0", dayOfMonth = "*", month = "*", year = "*", hour = "9-17", dayOfWeek = "Mon-Fri")
    @Override
    public void myTimer() {
        System.out.println("Timer event: " + new Date());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     @Resource 
   private SessionContext context;  
   public void createTimer(long duration) { 
      context.getTimerService().createTimer(duration, "Hello World!"); 
   }
    @Timeout 
   public void timeOutHandler(Timer timer){ 
      System.out.println("timeoutHandler : " + timer.getInfo());         
      timer.cancel(); 
   }
}
