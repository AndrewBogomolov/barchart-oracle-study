/*    */ package org.omg.IOP;
/*    */ 
/*    */ import org.omg.CORBA.Any;
/*    */ import org.omg.CORBA.ORB;
/*    */ import org.omg.CORBA.StructMember;
/*    */ import org.omg.CORBA.TCKind;
/*    */ import org.omg.CORBA.TypeCode;
/*    */ import org.omg.CORBA.portable.InputStream;
/*    */ import org.omg.CORBA.portable.OutputStream;
/*    */ 
/*    */ public abstract class TaggedProfileHelper
/*    */ {
/* 13 */   private static String _id = "IDL:omg.org/IOP/TaggedProfile:1.0";
/*    */ 
/* 28 */   private static TypeCode __typeCode = null;
/* 29 */   private static boolean __active = false;
/*    */ 
/*    */   public static void insert(Any paramAny, TaggedProfile paramTaggedProfile)
/*    */   {
/* 17 */     OutputStream localOutputStream = paramAny.create_output_stream();
/* 18 */     paramAny.type(type());
/* 19 */     write(localOutputStream, paramTaggedProfile);
/* 20 */     paramAny.read_value(localOutputStream.create_input_stream(), type());
/*    */   }
/*    */ 
/*    */   public static TaggedProfile extract(Any paramAny)
/*    */   {
/* 25 */     return read(paramAny.create_input_stream());
/*    */   }
/*    */ 
/*    */   public static synchronized TypeCode type()
/*    */   {
/* 32 */     if (__typeCode == null)
/*    */     {
/* 34 */       synchronized (TypeCode.class)
/*    */       {
/* 36 */         if (__typeCode == null)
/*    */         {
/* 38 */           if (__active)
/*    */           {
/* 40 */             return ORB.init().create_recursive_tc(_id);
/*    */           }
/* 42 */           __active = true;
/* 43 */           StructMember[] arrayOfStructMember = new StructMember[2];
/* 44 */           TypeCode localTypeCode = null;
/* 45 */           localTypeCode = ORB.init().get_primitive_tc(TCKind.tk_ulong);
/* 46 */           localTypeCode = ORB.init().create_alias_tc(ProfileIdHelper.id(), "ProfileId", localTypeCode);
/* 47 */           arrayOfStructMember[0] = new StructMember("tag", localTypeCode, null);
/*    */ 
/* 51 */           localTypeCode = ORB.init().get_primitive_tc(TCKind.tk_octet);
/* 52 */           localTypeCode = ORB.init().create_sequence_tc(0, localTypeCode);
/* 53 */           arrayOfStructMember[1] = new StructMember("profile_data", localTypeCode, null);
/*    */ 
/* 57 */           __typeCode = ORB.init().create_struct_tc(id(), "TaggedProfile", arrayOfStructMember);
/* 58 */           __active = false;
/*    */         }
/*    */       }
/*    */     }
/* 62 */     return __typeCode;
/*    */   }
/*    */ 
/*    */   public static String id()
/*    */   {
/* 67 */     return _id;
/*    */   }
/*    */ 
/*    */   public static TaggedProfile read(InputStream paramInputStream)
/*    */   {
/* 72 */     TaggedProfile localTaggedProfile = new TaggedProfile();
/* 73 */     localTaggedProfile.tag = paramInputStream.read_ulong();
/* 74 */     int i = paramInputStream.read_long();
/* 75 */     localTaggedProfile.profile_data = new byte[i];
/* 76 */     paramInputStream.read_octet_array(localTaggedProfile.profile_data, 0, i);
/* 77 */     return localTaggedProfile;
/*    */   }
/*    */ 
/*    */   public static void write(OutputStream paramOutputStream, TaggedProfile paramTaggedProfile)
/*    */   {
/* 82 */     paramOutputStream.write_ulong(paramTaggedProfile.tag);
/* 83 */     paramOutputStream.write_long(paramTaggedProfile.profile_data.length);
/* 84 */     paramOutputStream.write_octet_array(paramTaggedProfile.profile_data, 0, paramTaggedProfile.profile_data.length);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     org.omg.IOP.TaggedProfileHelper
 * JD-Core Version:    0.6.2
 */