/*    */ package org.omg.IOP;
/*    */ 
/*    */ import org.omg.CORBA.portable.IDLEntity;
/*    */ 
/*    */ public final class IOR
/*    */   implements IDLEntity
/*    */ {
/* 15 */   public String type_id = null;
/*    */ 
/* 21 */   public TaggedProfile[] profiles = null;
/*    */ 
/*    */   public IOR()
/*    */   {
/*    */   }
/*    */ 
/*    */   public IOR(String paramString, TaggedProfile[] paramArrayOfTaggedProfile)
/*    */   {
/* 29 */     this.type_id = paramString;
/* 30 */     this.profiles = paramArrayOfTaggedProfile;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     org.omg.IOP.IOR
 * JD-Core Version:    0.6.2
 */