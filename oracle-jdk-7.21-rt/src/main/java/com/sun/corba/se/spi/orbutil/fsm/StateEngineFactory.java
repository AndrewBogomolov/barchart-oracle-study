/*    */ package com.sun.corba.se.spi.orbutil.fsm;
/*    */ 
/*    */ import com.sun.corba.se.impl.orbutil.fsm.StateEngineImpl;
/*    */ 
/*    */ public class StateEngineFactory
/*    */ {
/*    */   public static StateEngine create()
/*    */   {
/* 40 */     return new StateEngineImpl();
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.corba.se.spi.orbutil.fsm.StateEngineFactory
 * JD-Core Version:    0.6.2
 */