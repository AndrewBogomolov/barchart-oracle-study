/*    */ package java.nio.charset;
/*    */ 
/*    */ public class IllegalCharsetNameException extends IllegalArgumentException
/*    */ {
/*    */   private static final long serialVersionUID = 1457525358470002989L;
/*    */   private String charsetName;
/*    */ 
/*    */   public IllegalCharsetNameException(String paramString)
/*    */   {
/* 55 */     super(String.valueOf(paramString));
/* 56 */     this.charsetName = paramString;
/*    */   }
/*    */ 
/*    */   public String getCharsetName()
/*    */   {
/* 65 */     return this.charsetName;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.nio.charset.IllegalCharsetNameException
 * JD-Core Version:    0.6.2
 */