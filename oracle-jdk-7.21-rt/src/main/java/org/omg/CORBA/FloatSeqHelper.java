/*    */ package org.omg.CORBA;
/*    */ 
/*    */ import org.omg.CORBA.portable.InputStream;
/*    */ import org.omg.CORBA.portable.OutputStream;
/*    */ 
/*    */ public abstract class FloatSeqHelper
/*    */ {
/* 52 */   private static String _id = "IDL:omg.org/CORBA/FloatSeq:1.0";
/*    */ 
/* 67 */   private static TypeCode __typeCode = null;
/*    */ 
/*    */   public static void insert(Any paramAny, float[] paramArrayOfFloat)
/*    */   {
/* 56 */     OutputStream localOutputStream = paramAny.create_output_stream();
/* 57 */     paramAny.type(type());
/* 58 */     write(localOutputStream, paramArrayOfFloat);
/* 59 */     paramAny.read_value(localOutputStream.create_input_stream(), type());
/*    */   }
/*    */ 
/*    */   public static float[] extract(Any paramAny)
/*    */   {
/* 64 */     return read(paramAny.create_input_stream());
/*    */   }
/*    */ 
/*    */   public static synchronized TypeCode type()
/*    */   {
/* 70 */     if (__typeCode == null)
/*    */     {
/* 72 */       __typeCode = ORB.init().get_primitive_tc(TCKind.tk_float);
/* 73 */       __typeCode = ORB.init().create_sequence_tc(0, __typeCode);
/* 74 */       __typeCode = ORB.init().create_alias_tc(id(), "FloatSeq", __typeCode);
/*    */     }
/* 76 */     return __typeCode;
/*    */   }
/*    */ 
/*    */   public static String id()
/*    */   {
/* 81 */     return _id;
/*    */   }
/*    */ 
/*    */   public static float[] read(InputStream paramInputStream)
/*    */   {
/* 86 */     float[] arrayOfFloat = null;
/* 87 */     int i = paramInputStream.read_long();
/* 88 */     arrayOfFloat = new float[i];
/* 89 */     paramInputStream.read_float_array(arrayOfFloat, 0, i);
/* 90 */     return arrayOfFloat;
/*    */   }
/*    */ 
/*    */   public static void write(OutputStream paramOutputStream, float[] paramArrayOfFloat)
/*    */   {
/* 95 */     paramOutputStream.write_long(paramArrayOfFloat.length);
/* 96 */     paramOutputStream.write_float_array(paramArrayOfFloat, 0, paramArrayOfFloat.length);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     org.omg.CORBA.FloatSeqHelper
 * JD-Core Version:    0.6.2
 */