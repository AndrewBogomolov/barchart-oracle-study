/*    */ package com.sun.org.apache.bcel.internal.generic;
/*    */ 
/*    */ public class DUP extends StackInstruction
/*    */   implements PushInstruction
/*    */ {
/*    */   public DUP()
/*    */   {
/* 69 */     super((short)89);
/*    */   }
/*    */ 
/*    */   public void accept(Visitor v)
/*    */   {
/* 82 */     v.visitStackProducer(this);
/* 83 */     v.visitPushInstruction(this);
/* 84 */     v.visitStackInstruction(this);
/* 85 */     v.visitDUP(this);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.bcel.internal.generic.DUP
 * JD-Core Version:    0.6.2
 */