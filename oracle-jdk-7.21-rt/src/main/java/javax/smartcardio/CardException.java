/*    */ package javax.smartcardio;
/*    */ 
/*    */ public class CardException extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 7787607144922050628L;
/*    */ 
/*    */   public CardException(String paramString)
/*    */   {
/* 46 */     super(paramString);
/*    */   }
/*    */ 
/*    */   public CardException(Throwable paramThrowable)
/*    */   {
/* 56 */     super(paramThrowable);
/*    */   }
/*    */ 
/*    */   public CardException(String paramString, Throwable paramThrowable)
/*    */   {
/* 66 */     super(paramString, paramThrowable);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.smartcardio.CardException
 * JD-Core Version:    0.6.2
 */