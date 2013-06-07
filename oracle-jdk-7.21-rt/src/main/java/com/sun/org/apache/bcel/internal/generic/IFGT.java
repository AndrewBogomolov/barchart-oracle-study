/*    */ package com.sun.org.apache.bcel.internal.generic;
/*    */ 
/*    */ public class IFGT extends IfInstruction
/*    */ {
/*    */   IFGT()
/*    */   {
/*    */   }
/*    */ 
/*    */   public IFGT(InstructionHandle target)
/*    */   {
/* 76 */     super((short)157, target);
/*    */   }
/*    */ 
/*    */   public IfInstruction negate()
/*    */   {
/* 83 */     return new IFLE(this.target);
/*    */   }
/*    */ 
/*    */   public void accept(Visitor v)
/*    */   {
/* 96 */     v.visitStackConsumer(this);
/* 97 */     v.visitBranchInstruction(this);
/* 98 */     v.visitIfInstruction(this);
/* 99 */     v.visitIFGT(this);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.bcel.internal.generic.IFGT
 * JD-Core Version:    0.6.2
 */