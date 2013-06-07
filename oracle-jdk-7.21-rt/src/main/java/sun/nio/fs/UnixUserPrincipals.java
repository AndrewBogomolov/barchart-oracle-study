/*     */ package sun.nio.fs;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.file.attribute.GroupPrincipal;
/*     */ import java.nio.file.attribute.UserPrincipal;
/*     */ import java.nio.file.attribute.UserPrincipalNotFoundException;
/*     */ 
/*     */ class UnixUserPrincipals
/*     */ {
/*  39 */   static final User SPECIAL_OWNER = createSpecial("OWNER@");
/*  40 */   static final User SPECIAL_GROUP = createSpecial("GROUP@");
/*  41 */   static final User SPECIAL_EVERYONE = createSpecial("EVERYONE@");
/*     */ 
/*     */   private static User createSpecial(String paramString)
/*     */   {
/*  37 */     return new User(-1, paramString);
/*     */   }
/*     */ 
/*     */   static User fromUid(int paramInt)
/*     */   {
/* 116 */     String str = null;
/*     */     try {
/* 118 */       str = new String(UnixNativeDispatcher.getpwuid(paramInt));
/*     */     } catch (UnixException localUnixException) {
/* 120 */       str = Integer.toString(paramInt);
/*     */     }
/* 122 */     return new User(paramInt, str);
/*     */   }
/*     */ 
/*     */   static Group fromGid(int paramInt)
/*     */   {
/* 127 */     String str = null;
/*     */     try {
/* 129 */       str = new String(UnixNativeDispatcher.getgrgid(paramInt));
/*     */     } catch (UnixException localUnixException) {
/* 131 */       str = Integer.toString(paramInt);
/*     */     }
/* 133 */     return new Group(paramInt, str);
/*     */   }
/*     */ 
/*     */   private static int lookupName(String paramString, boolean paramBoolean)
/*     */     throws IOException
/*     */   {
/* 140 */     SecurityManager localSecurityManager = System.getSecurityManager();
/* 141 */     if (localSecurityManager != null) {
/* 142 */       localSecurityManager.checkPermission(new RuntimePermission("lookupUserInformation"));
/*     */     }
/* 144 */     int i = -1;
/*     */     try {
/* 146 */       i = paramBoolean ? UnixNativeDispatcher.getgrnam(paramString) : UnixNativeDispatcher.getpwnam(paramString);
/*     */     } catch (UnixException localUnixException) {
/* 148 */       throw new IOException(paramString + ": " + localUnixException.errorString());
/*     */     }
/* 150 */     if (i == -1) {
/*     */       try
/*     */       {
/* 153 */         i = Integer.parseInt(paramString);
/*     */       } catch (NumberFormatException localNumberFormatException) {
/* 155 */         throw new UserPrincipalNotFoundException(paramString);
/*     */       }
/*     */     }
/* 158 */     return i;
/*     */   }
/*     */ 
/*     */   static UserPrincipal lookupUser(String paramString)
/*     */     throws IOException
/*     */   {
/* 164 */     if (paramString.equals(SPECIAL_OWNER.getName()))
/* 165 */       return SPECIAL_OWNER;
/* 166 */     if (paramString.equals(SPECIAL_GROUP.getName()))
/* 167 */       return SPECIAL_GROUP;
/* 168 */     if (paramString.equals(SPECIAL_EVERYONE.getName()))
/* 169 */       return SPECIAL_EVERYONE;
/* 170 */     int i = lookupName(paramString, false);
/* 171 */     return new User(i, paramString);
/*     */   }
/*     */ 
/*     */   static GroupPrincipal lookupGroup(String paramString)
/*     */     throws IOException
/*     */   {
/* 178 */     int i = lookupName(paramString, true);
/* 179 */     return new Group(i, paramString);
/*     */   }
/*     */ 
/*     */   static class Group extends UnixUserPrincipals.User
/*     */     implements GroupPrincipal
/*     */   {
/*     */     Group(int paramInt, String paramString)
/*     */     {
/* 110 */       super(true, paramString, null);
/*     */     }
/*     */   }
/*     */ 
/*     */   static class User
/*     */     implements UserPrincipal
/*     */   {
/*     */     private final int id;
/*     */     private final boolean isGroup;
/*     */     private final String name;
/*     */ 
/*     */     private User(int paramInt, boolean paramBoolean, String paramString)
/*     */     {
/*  49 */       this.id = paramInt;
/*  50 */       this.isGroup = paramBoolean;
/*  51 */       this.name = paramString;
/*     */     }
/*     */ 
/*     */     User(int paramInt, String paramString) {
/*  55 */       this(paramInt, false, paramString);
/*     */     }
/*     */ 
/*     */     int uid() {
/*  59 */       if (this.isGroup)
/*  60 */         throw new AssertionError();
/*  61 */       return this.id;
/*     */     }
/*     */ 
/*     */     int gid() {
/*  65 */       if (this.isGroup)
/*  66 */         return this.id;
/*  67 */       throw new AssertionError();
/*     */     }
/*     */ 
/*     */     boolean isSpecial() {
/*  71 */       return this.id == -1;
/*     */     }
/*     */ 
/*     */     public String getName()
/*     */     {
/*  76 */       return this.name;
/*     */     }
/*     */ 
/*     */     public String toString()
/*     */     {
/*  81 */       return this.name;
/*     */     }
/*     */ 
/*     */     public boolean equals(Object paramObject)
/*     */     {
/*  86 */       if (paramObject == this)
/*  87 */         return true;
/*  88 */       if (!(paramObject instanceof User))
/*  89 */         return false;
/*  90 */       User localUser = (User)paramObject;
/*  91 */       if ((this.id != localUser.id) || (this.isGroup != localUser.isGroup))
/*     */       {
/*  93 */         return false;
/*     */       }
/*     */ 
/*  96 */       if ((this.id == -1) && (localUser.id == -1)) {
/*  97 */         return this.name.equals(localUser.name);
/*     */       }
/*  99 */       return true;
/*     */     }
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 104 */       return this.id != -1 ? this.id : this.name.hashCode();
/*     */     }
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.nio.fs.UnixUserPrincipals
 * JD-Core Version:    0.6.2
 */