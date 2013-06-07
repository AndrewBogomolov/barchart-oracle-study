/*    */ package com.sun.nio.sctp;
/*    */ 
/*    */ public abstract class AssociationChangeNotification
/*    */   implements Notification
/*    */ {
/*    */   public abstract Association association();
/*    */ 
/*    */   public abstract AssocChangeEvent event();
/*    */ 
/*    */   public static enum AssocChangeEvent
/*    */   {
/* 45 */     COMM_UP, 
/*    */ 
/* 51 */     COMM_LOST, 
/*    */ 
/* 56 */     RESTART, 
/*    */ 
/* 61 */     SHUTDOWN, 
/*    */ 
/* 69 */     CANT_START;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.nio.sctp.AssociationChangeNotification
 * JD-Core Version:    0.6.2
 */