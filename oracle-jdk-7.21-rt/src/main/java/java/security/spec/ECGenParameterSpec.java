/*    */ package java.security.spec;
/*    */ 
/*    */ public class ECGenParameterSpec
/*    */   implements AlgorithmParameterSpec
/*    */ {
/*    */   private String name;
/*    */ 
/*    */   public ECGenParameterSpec(String paramString)
/*    */   {
/* 54 */     if (paramString == null) {
/* 55 */       throw new NullPointerException("stdName is null");
/*    */     }
/* 57 */     this.name = paramString;
/*    */   }
/*    */ 
/*    */   public String getName()
/*    */   {
/* 66 */     return this.name;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.security.spec.ECGenParameterSpec
 * JD-Core Version:    0.6.2
 */