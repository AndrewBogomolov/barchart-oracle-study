/*     */ package java.lang;
/*     */ 
/*     */ public class Exception extends Throwable
/*     */ {
/*     */   static final long serialVersionUID = -3387516993124229948L;
/*     */ 
/*     */   public Exception()
/*     */   {
/*     */   }
/*     */ 
/*     */   public Exception(String paramString)
/*     */   {
/*  66 */     super(paramString);
/*     */   }
/*     */ 
/*     */   public Exception(String paramString, Throwable paramThrowable)
/*     */   {
/*  84 */     super(paramString, paramThrowable);
/*     */   }
/*     */ 
/*     */   public Exception(Throwable paramThrowable)
/*     */   {
/* 102 */     super(paramThrowable);
/*     */   }
/*     */ 
/*     */   protected Exception(String paramString, Throwable paramThrowable, boolean paramBoolean1, boolean paramBoolean2)
/*     */   {
/* 122 */     super(paramString, paramThrowable, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.lang.Exception
 * JD-Core Version:    0.6.2
 */