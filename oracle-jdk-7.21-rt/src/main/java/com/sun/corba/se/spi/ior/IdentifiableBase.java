/*    */ package com.sun.corba.se.spi.ior;
/*    */ 
/*    */ import com.sun.corba.se.impl.ior.EncapsulationUtility;
/*    */ import org.omg.CORBA_2_3.portable.OutputStream;
/*    */ 
/*    */ public abstract class IdentifiableBase
/*    */   implements Identifiable, WriteContents
/*    */ {
/*    */   public final void write(OutputStream paramOutputStream)
/*    */   {
/* 51 */     EncapsulationUtility.writeEncapsulation(this, paramOutputStream);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.corba.se.spi.ior.IdentifiableBase
 * JD-Core Version:    0.6.2
 */