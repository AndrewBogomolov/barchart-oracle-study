/*     */ package java.security;
/*     */ 
/*     */ public final class SecurityPermission extends BasicPermission
/*     */ {
/*     */   private static final long serialVersionUID = 5236109936224050470L;
/*     */ 
/*     */   public SecurityPermission(String paramString)
/*     */   {
/* 312 */     super(paramString);
/*     */   }
/*     */ 
/*     */   public SecurityPermission(String paramString1, String paramString2)
/*     */   {
/* 329 */     super(paramString1, paramString2);
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.security.SecurityPermission
 * JD-Core Version:    0.6.2
 */