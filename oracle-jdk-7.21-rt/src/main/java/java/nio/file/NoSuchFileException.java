/*    */ package java.nio.file;
/*    */ 
/*    */ public class NoSuchFileException extends FileSystemException
/*    */ {
/*    */   static final long serialVersionUID = -1390291775875351931L;
/*    */ 
/*    */   public NoSuchFileException(String paramString)
/*    */   {
/* 47 */     super(paramString);
/*    */   }
/*    */ 
/*    */   public NoSuchFileException(String paramString1, String paramString2, String paramString3)
/*    */   {
/* 61 */     super(paramString1, paramString2, paramString3);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.nio.file.NoSuchFileException
 * JD-Core Version:    0.6.2
 */