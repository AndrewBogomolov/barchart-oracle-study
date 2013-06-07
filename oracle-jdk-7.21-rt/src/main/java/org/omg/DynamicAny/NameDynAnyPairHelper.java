/*    */ package org.omg.DynamicAny;
/*    */ 
/*    */ import org.omg.CORBA.Any;
/*    */ import org.omg.CORBA.ORB;
/*    */ import org.omg.CORBA.StructMember;
/*    */ import org.omg.CORBA.TypeCode;
/*    */ import org.omg.CORBA.portable.InputStream;
/*    */ import org.omg.CORBA.portable.OutputStream;
/*    */ 
/*    */ public abstract class NameDynAnyPairHelper
/*    */ {
/* 13 */   private static String _id = "IDL:omg.org/DynamicAny/NameDynAnyPair:1.0";
/*    */ 
/* 28 */   private static TypeCode __typeCode = null;
/* 29 */   private static boolean __active = false;
/*    */ 
/*    */   public static void insert(Any paramAny, NameDynAnyPair paramNameDynAnyPair)
/*    */   {
/* 17 */     OutputStream localOutputStream = paramAny.create_output_stream();
/* 18 */     paramAny.type(type());
/* 19 */     write(localOutputStream, paramNameDynAnyPair);
/* 20 */     paramAny.read_value(localOutputStream.create_input_stream(), type());
/*    */   }
/*    */ 
/*    */   public static NameDynAnyPair extract(Any paramAny)
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
/* 45 */           localTypeCode = ORB.init().create_string_tc(0);
/* 46 */           localTypeCode = ORB.init().create_alias_tc(FieldNameHelper.id(), "FieldName", localTypeCode);
/* 47 */           arrayOfStructMember[0] = new StructMember("id", localTypeCode, null);
/*    */ 
/* 51 */           localTypeCode = DynAnyHelper.type();
/* 52 */           arrayOfStructMember[1] = new StructMember("value", localTypeCode, null);
/*    */ 
/* 56 */           __typeCode = ORB.init().create_struct_tc(id(), "NameDynAnyPair", arrayOfStructMember);
/* 57 */           __active = false;
/*    */         }
/*    */       }
/*    */     }
/* 61 */     return __typeCode;
/*    */   }
/*    */ 
/*    */   public static String id()
/*    */   {
/* 66 */     return _id;
/*    */   }
/*    */ 
/*    */   public static NameDynAnyPair read(InputStream paramInputStream)
/*    */   {
/* 71 */     NameDynAnyPair localNameDynAnyPair = new NameDynAnyPair();
/* 72 */     localNameDynAnyPair.id = paramInputStream.read_string();
/* 73 */     localNameDynAnyPair.value = DynAnyHelper.read(paramInputStream);
/* 74 */     return localNameDynAnyPair;
/*    */   }
/*    */ 
/*    */   public static void write(OutputStream paramOutputStream, NameDynAnyPair paramNameDynAnyPair)
/*    */   {
/* 79 */     paramOutputStream.write_string(paramNameDynAnyPair.id);
/* 80 */     DynAnyHelper.write(paramOutputStream, paramNameDynAnyPair.value);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     org.omg.DynamicAny.NameDynAnyPairHelper
 * JD-Core Version:    0.6.2
 */