/*    */ package java.nio.file;
/*    */ 
/*    */ public class FileAlreadyExistsException extends FileSystemException
/*    */ {
/*    */   static final long serialVersionUID = 7579540934498831181L;
/*    */ 
/*    */   public FileAlreadyExistsException(String paramString)
/*    */   {
/* 47 */     super(paramString);
/*    */   }
/*    */ 
/*    */   public FileAlreadyExistsException(String paramString1, String paramString2, String paramString3)
/*    */   {
/* 61 */     super(paramString1, paramString2, paramString3);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.nio.file.FileAlreadyExistsException
 * JD-Core Version:    0.6.2
 */