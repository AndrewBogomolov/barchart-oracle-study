/*     */ package java.io;
/*     */ 
/*     */ import java.security.BasicPermission;
/*     */ 
/*     */ public final class SerializablePermission extends BasicPermission
/*     */ {
/*     */   private static final long serialVersionUID = 8537212141160296410L;
/*     */   private String actions;
/*     */ 
/*     */   public SerializablePermission(String paramString)
/*     */   {
/* 113 */     super(paramString);
/*     */   }
/*     */ 
/*     */   public SerializablePermission(String paramString1, String paramString2)
/*     */   {
/* 130 */     super(paramString1, paramString2);
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.io.SerializablePermission
 * JD-Core Version:    0.6.2
 */