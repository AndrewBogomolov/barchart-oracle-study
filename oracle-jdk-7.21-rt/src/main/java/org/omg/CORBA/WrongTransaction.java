/*    */ package org.omg.CORBA;
/*    */ 
/*    */ public final class WrongTransaction extends UserException
/*    */ {
/*    */   public WrongTransaction()
/*    */   {
/* 46 */     super(WrongTransactionHelper.id());
/*    */   }
/*    */ 
/*    */   public WrongTransaction(String paramString)
/*    */   {
/* 54 */     super(WrongTransactionHelper.id() + "  " + paramString);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     org.omg.CORBA.WrongTransaction
 * JD-Core Version:    0.6.2
 */