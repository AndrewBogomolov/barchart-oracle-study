/*    */ package sun.security.krb5;
/*    */ 
/*    */ public class RealmException extends KrbException
/*    */ {
/*    */   private static final long serialVersionUID = -9100385213693792864L;
/*    */ 
/*    */   public RealmException(int paramInt)
/*    */   {
/* 39 */     super(paramInt);
/*    */   }
/*    */ 
/*    */   public RealmException(String paramString) {
/* 43 */     super(paramString);
/*    */   }
/*    */ 
/*    */   public RealmException(int paramInt, String paramString) {
/* 47 */     super(paramInt, paramString);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.security.krb5.RealmException
 * JD-Core Version:    0.6.2
 */