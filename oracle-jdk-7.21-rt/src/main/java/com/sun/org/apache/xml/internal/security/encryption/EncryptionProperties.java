package com.sun.org.apache.xml.internal.security.encryption;

import java.util.Iterator;

public abstract interface EncryptionProperties
{
  public abstract String getId();

  public abstract void setId(String paramString);

  public abstract Iterator getEncryptionProperties();

  public abstract void addEncryptionProperty(EncryptionProperty paramEncryptionProperty);

  public abstract void removeEncryptionProperty(EncryptionProperty paramEncryptionProperty);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xml.internal.security.encryption.EncryptionProperties
 * JD-Core Version:    0.6.2
 */