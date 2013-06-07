/*    */ package java.lang;
/*    */ 
/*    */ public class NumberFormatException extends IllegalArgumentException
/*    */ {
/*    */   static final long serialVersionUID = -2848938806368998894L;
/*    */ 
/*    */   public NumberFormatException()
/*    */   {
/*    */   }
/*    */ 
/*    */   public NumberFormatException(String paramString)
/*    */   {
/* 55 */     super(paramString);
/*    */   }
/*    */ 
/*    */   static NumberFormatException forInputString(String paramString)
/*    */   {
/* 65 */     return new NumberFormatException("For input string: \"" + paramString + "\"");
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.lang.NumberFormatException
 * JD-Core Version:    0.6.2
 */