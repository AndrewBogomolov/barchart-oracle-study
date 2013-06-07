package com.sun.java.util.jar.pack;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

abstract interface CodingMethod
{
  public abstract void readArrayFrom(InputStream paramInputStream, int[] paramArrayOfInt, int paramInt1, int paramInt2)
    throws IOException;

  public abstract void writeArrayTo(OutputStream paramOutputStream, int[] paramArrayOfInt, int paramInt1, int paramInt2)
    throws IOException;

  public abstract byte[] getMetaCoding(Coding paramCoding);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.java.util.jar.pack.CodingMethod
 * JD-Core Version:    0.6.2
 */