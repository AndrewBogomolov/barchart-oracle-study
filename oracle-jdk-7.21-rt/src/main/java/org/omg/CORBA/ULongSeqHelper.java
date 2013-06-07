/*    */ package org.omg.CORBA;
/*    */ 
/*    */ import org.omg.CORBA.portable.InputStream;
/*    */ import org.omg.CORBA.portable.OutputStream;
/*    */ 
/*    */ public abstract class ULongSeqHelper
/*    */ {
/* 52 */   private static String _id = "IDL:omg.org/CORBA/ULongSeq:1.0";
/*    */ 
/* 67 */   private static TypeCode __typeCode = null;
/*    */ 
/*    */   public static void insert(Any paramAny, int[] paramArrayOfInt)
/*    */   {
/* 56 */     OutputStream localOutputStream = paramAny.create_output_stream();
/* 57 */     paramAny.type(type());
/* 58 */     write(localOutputStream, paramArrayOfInt);
/* 59 */     paramAny.read_value(localOutputStream.create_input_stream(), type());
/*    */   }
/*    */ 
/*    */   public static int[] extract(Any paramAny)
/*    */   {
/* 64 */     return read(paramAny.create_input_stream());
/*    */   }
/*    */ 
/*    */   public static synchronized TypeCode type()
/*    */   {
/* 70 */     if (__typeCode == null)
/*    */     {
/* 72 */       __typeCode = ORB.init().get_primitive_tc(TCKind.tk_ulong);
/* 73 */       __typeCode = ORB.init().create_sequence_tc(0, __typeCode);
/* 74 */       __typeCode = ORB.init().create_alias_tc(id(), "ULongSeq", __typeCode);
/*    */     }
/* 76 */     return __typeCode;
/*    */   }
/*    */ 
/*    */   public static String id()
/*    */   {
/* 81 */     return _id;
/*    */   }
/*    */ 
/*    */   public static int[] read(InputStream paramInputStream)
/*    */   {
/* 86 */     int[] arrayOfInt = null;
/* 87 */     int i = paramInputStream.read_long();
/* 88 */     arrayOfInt = new int[i];
/* 89 */     paramInputStream.read_ulong_array(arrayOfInt, 0, i);
/* 90 */     return arrayOfInt;
/*    */   }
/*    */ 
/*    */   public static void write(OutputStream paramOutputStream, int[] paramArrayOfInt)
/*    */   {
/* 95 */     paramOutputStream.write_long(paramArrayOfInt.length);
/* 96 */     paramOutputStream.write_ulong_array(paramArrayOfInt, 0, paramArrayOfInt.length);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     org.omg.CORBA.ULongSeqHelper
 * JD-Core Version:    0.6.2
 */