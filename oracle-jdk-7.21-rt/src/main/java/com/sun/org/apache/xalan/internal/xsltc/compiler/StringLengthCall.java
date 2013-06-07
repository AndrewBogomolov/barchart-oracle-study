/*    */ package com.sun.org.apache.xalan.internal.xsltc.compiler;
/*    */ 
/*    */ import com.sun.org.apache.bcel.internal.generic.ConstantPoolGen;
/*    */ import com.sun.org.apache.bcel.internal.generic.INVOKEVIRTUAL;
/*    */ import com.sun.org.apache.bcel.internal.generic.InstructionList;
/*    */ import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ClassGenerator;
/*    */ import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MethodGenerator;
/*    */ import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
/*    */ import java.util.Vector;
/*    */ 
/*    */ final class StringLengthCall extends FunctionCall
/*    */ {
/*    */   public StringLengthCall(QName fname, Vector arguments)
/*    */   {
/* 41 */     super(fname, arguments);
/*    */   }
/*    */ 
/*    */   public void translate(ClassGenerator classGen, MethodGenerator methodGen) {
/* 45 */     ConstantPoolGen cpg = classGen.getConstantPool();
/* 46 */     InstructionList il = methodGen.getInstructionList();
/* 47 */     if (argumentCount() > 0) {
/* 48 */       argument().translate(classGen, methodGen);
/*    */     }
/*    */     else {
/* 51 */       il.append(methodGen.loadContextNode());
/* 52 */       Type.Node.translateTo(classGen, methodGen, Type.String);
/*    */     }
/* 54 */     il.append(new INVOKEVIRTUAL(cpg.addMethodref("java.lang.String", "length", "()I")));
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xalan.internal.xsltc.compiler.StringLengthCall
 * JD-Core Version:    0.6.2
 */