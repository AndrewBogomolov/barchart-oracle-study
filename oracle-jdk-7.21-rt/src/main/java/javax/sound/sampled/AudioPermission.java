/*     */ package javax.sound.sampled;
/*     */ 
/*     */ import java.security.BasicPermission;
/*     */ 
/*     */ public class AudioPermission extends BasicPermission
/*     */ {
/*     */   public AudioPermission(String paramString)
/*     */   {
/* 219 */     super(paramString);
/*     */   }
/*     */ 
/*     */   public AudioPermission(String paramString1, String paramString2)
/*     */   {
/* 234 */     super(paramString1, paramString2);
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.sound.sampled.AudioPermission
 * JD-Core Version:    0.6.2
 */