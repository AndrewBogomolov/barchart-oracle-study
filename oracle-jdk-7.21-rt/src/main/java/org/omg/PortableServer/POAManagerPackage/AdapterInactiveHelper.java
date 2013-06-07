/*    */ package org.omg.PortableServer.POAManagerPackage;
/*    */ 
/*    */ import org.omg.CORBA.Any;
/*    */ import org.omg.CORBA.ORB;
/*    */ import org.omg.CORBA.StructMember;
/*    */ import org.omg.CORBA.TypeCode;
/*    */ import org.omg.CORBA.portable.InputStream;
/*    */ import org.omg.CORBA.portable.OutputStream;
/*    */ 
/*    */ public abstract class AdapterInactiveHelper
/*    */ {
/* 13 */   private static String _id = "IDL:omg.org/PortableServer/POAManager/AdapterInactive:1.0";
/*    */ 
/* 28 */   private static TypeCode __typeCode = null;
/* 29 */   private static boolean __active = false;
/*    */ 
/*    */   public static void insert(Any paramAny, AdapterInactive paramAdapterInactive)
/*    */   {
/* 17 */     OutputStream localOutputStream = paramAny.create_output_stream();
/* 18 */     paramAny.type(type());
/* 19 */     write(localOutputStream, paramAdapterInactive);
/* 20 */     paramAny.read_value(localOutputStream.create_input_stream(), type());
/*    */   }
/*    */ 
/*    */   public static AdapterInactive extract(Any paramAny)
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
/* 43 */           StructMember[] arrayOfStructMember = new StructMember[0];
/* 44 */           Object localObject1 = null;
/* 45 */           __typeCode = ORB.init().create_exception_tc(id(), "AdapterInactive", arrayOfStructMember);
/* 46 */           __active = false;
/*    */         }
/*    */       }
/*    */     }
/* 50 */     return __typeCode;
/*    */   }
/*    */ 
/*    */   public static String id()
/*    */   {
/* 55 */     return _id;
/*    */   }
/*    */ 
/*    */   public static AdapterInactive read(InputStream paramInputStream)
/*    */   {
/* 60 */     AdapterInactive localAdapterInactive = new AdapterInactive();
/*    */ 
/* 62 */     paramInputStream.read_string();
/* 63 */     return localAdapterInactive;
/*    */   }
/*    */ 
/*    */   public static void write(OutputStream paramOutputStream, AdapterInactive paramAdapterInactive)
/*    */   {
/* 69 */     paramOutputStream.write_string(id());
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     org.omg.PortableServer.POAManagerPackage.AdapterInactiveHelper
 * JD-Core Version:    0.6.2
 */