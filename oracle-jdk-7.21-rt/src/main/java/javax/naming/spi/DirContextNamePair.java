/*     */ package javax.naming.spi;
/*     */ 
/*     */ import javax.naming.Name;
/*     */ import javax.naming.directory.DirContext;
/*     */ 
/*     */ class DirContextNamePair
/*     */ {
/*     */   DirContext ctx;
/*     */   Name name;
/*     */ 
/*     */   DirContextNamePair(DirContext paramDirContext, Name paramName)
/*     */   {
/* 304 */     this.ctx = paramDirContext;
/* 305 */     this.name = paramName;
/*     */   }
/*     */ 
/*     */   DirContext getDirContext() {
/* 309 */     return this.ctx;
/*     */   }
/*     */ 
/*     */   Name getName() {
/* 313 */     return this.name;
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.naming.spi.DirContextNamePair
 * JD-Core Version:    0.6.2
 */