/*    */ package java.lang.reflect;
/*    */ 
/*    */ import java.security.BasicPermission;
/*    */ 
/*    */ public final class ReflectPermission extends BasicPermission
/*    */ {
/*    */   private static final long serialVersionUID = 7412737110241507485L;
/*    */ 
/*    */   public ReflectPermission(String paramString)
/*    */   {
/* 83 */     super(paramString);
/*    */   }
/*    */ 
/*    */   public ReflectPermission(String paramString1, String paramString2)
/*    */   {
/* 98 */     super(paramString1, paramString2);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.lang.reflect.ReflectPermission
 * JD-Core Version:    0.6.2
 */