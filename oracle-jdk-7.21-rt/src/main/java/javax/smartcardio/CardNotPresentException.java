/*    */ package javax.smartcardio;
/*    */ 
/*    */ public class CardNotPresentException extends CardException
/*    */ {
/*    */   private static final long serialVersionUID = 1346879911706545215L;
/*    */ 
/*    */   public CardNotPresentException(String paramString)
/*    */   {
/* 46 */     super(paramString);
/*    */   }
/*    */ 
/*    */   public CardNotPresentException(Throwable paramThrowable)
/*    */   {
/* 56 */     super(paramThrowable);
/*    */   }
/*    */ 
/*    */   public CardNotPresentException(String paramString, Throwable paramThrowable)
/*    */   {
/* 66 */     super(paramString, paramThrowable);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.smartcardio.CardNotPresentException
 * JD-Core Version:    0.6.2
 */