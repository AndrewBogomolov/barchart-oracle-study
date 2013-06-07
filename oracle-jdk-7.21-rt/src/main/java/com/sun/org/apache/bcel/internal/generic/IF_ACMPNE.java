/*    */ package com.sun.org.apache.bcel.internal.generic;
/*    */ 
/*    */ public class IF_ACMPNE extends IfInstruction
/*    */ {
/*    */   IF_ACMPNE()
/*    */   {
/*    */   }
/*    */ 
/*    */   public IF_ACMPNE(InstructionHandle target)
/*    */   {
/* 76 */     super((short)166, target);
/*    */   }
/*    */ 
/*    */   public IfInstruction negate()
/*    */   {
/* 83 */     return new IF_ACMPEQ(this.target);
/*    */   }
/*    */ 
/*    */   public void accept(Visitor v)
/*    */   {
/* 96 */     v.visitStackConsumer(this);
/* 97 */     v.visitBranchInstruction(this);
/* 98 */     v.visitIfInstruction(this);
/* 99 */     v.visitIF_ACMPNE(this);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.bcel.internal.generic.IF_ACMPNE
 * JD-Core Version:    0.6.2
 */