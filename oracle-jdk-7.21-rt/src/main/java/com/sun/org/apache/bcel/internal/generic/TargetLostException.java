/*     */ package com.sun.org.apache.bcel.internal.generic;
/*     */ 
/*     */ public final class TargetLostException extends Exception
/*     */ {
/*     */   private InstructionHandle[] targets;
/*     */ 
/*     */   TargetLostException(InstructionHandle[] t, String mesg)
/*     */   {
/*  95 */     super(mesg);
/*  96 */     this.targets = t;
/*     */   }
/*     */ 
/*     */   public InstructionHandle[] getTargets()
/*     */   {
/* 102 */     return this.targets;
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.bcel.internal.generic.TargetLostException
 * JD-Core Version:    0.6.2
 */