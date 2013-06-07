/*    */ package sun.security.action;
/*    */ 
/*    */ import java.security.PrivilegedAction;
/*    */ 
/*    */ public class GetBooleanAction
/*    */   implements PrivilegedAction<Boolean>
/*    */ {
/*    */   private String theProp;
/*    */ 
/*    */   public GetBooleanAction(String paramString)
/*    */   {
/* 60 */     this.theProp = paramString;
/*    */   }
/*    */ 
/*    */   public Boolean run()
/*    */   {
/* 70 */     return Boolean.valueOf(Boolean.getBoolean(this.theProp));
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.security.action.GetBooleanAction
 * JD-Core Version:    0.6.2
 */