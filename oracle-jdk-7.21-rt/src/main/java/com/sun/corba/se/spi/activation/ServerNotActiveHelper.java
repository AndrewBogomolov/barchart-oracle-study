/*    */ package com.sun.corba.se.spi.activation;
/*    */ 
/*    */ import org.omg.CORBA.Any;
/*    */ import org.omg.CORBA.ORB;
/*    */ import org.omg.CORBA.StructMember;
/*    */ import org.omg.CORBA.TCKind;
/*    */ import org.omg.CORBA.TypeCode;
/*    */ import org.omg.CORBA.portable.InputStream;
/*    */ import org.omg.CORBA.portable.OutputStream;
/*    */ 
/*    */ public abstract class ServerNotActiveHelper
/*    */ {
/* 13 */   private static String _id = "IDL:activation/ServerNotActive:1.0";
/*    */ 
/* 28 */   private static TypeCode __typeCode = null;
/* 29 */   private static boolean __active = false;
/*    */ 
/*    */   public static void insert(Any paramAny, ServerNotActive paramServerNotActive)
/*    */   {
/* 17 */     OutputStream localOutputStream = paramAny.create_output_stream();
/* 18 */     paramAny.type(type());
/* 19 */     write(localOutputStream, paramServerNotActive);
/* 20 */     paramAny.read_value(localOutputStream.create_input_stream(), type());
/*    */   }
/*    */ 
/*    */   public static ServerNotActive extract(Any paramAny)
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
/* 43 */           StructMember[] arrayOfStructMember = new StructMember[1];
/* 44 */           TypeCode localTypeCode = null;
/* 45 */           localTypeCode = ORB.init().get_primitive_tc(TCKind.tk_long);
/* 46 */           localTypeCode = ORB.init().create_alias_tc(ServerIdHelper.id(), "ServerId", localTypeCode);
/* 47 */           arrayOfStructMember[0] = new StructMember("serverId", localTypeCode, null);
/*    */ 
/* 51 */           __typeCode = ORB.init().create_exception_tc(id(), "ServerNotActive", arrayOfStructMember);
/* 52 */           __active = false;
/*    */         }
/*    */       }
/*    */     }
/* 56 */     return __typeCode;
/*    */   }
/*    */ 
/*    */   public static String id()
/*    */   {
/* 61 */     return _id;
/*    */   }
/*    */ 
/*    */   public static ServerNotActive read(InputStream paramInputStream)
/*    */   {
/* 66 */     ServerNotActive localServerNotActive = new ServerNotActive();
/*    */ 
/* 68 */     paramInputStream.read_string();
/* 69 */     localServerNotActive.serverId = paramInputStream.read_long();
/* 70 */     return localServerNotActive;
/*    */   }
/*    */ 
/*    */   public static void write(OutputStream paramOutputStream, ServerNotActive paramServerNotActive)
/*    */   {
/* 76 */     paramOutputStream.write_string(id());
/* 77 */     paramOutputStream.write_long(paramServerNotActive.serverId);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.corba.se.spi.activation.ServerNotActiveHelper
 * JD-Core Version:    0.6.2
 */