package com.sun.org.apache.xerces.internal.impl.xs.identity;

import com.sun.org.apache.xerces.internal.xs.ShortList;

public abstract interface ValueStore
{
  public abstract void addValue(Field paramField, Object paramObject, short paramShort, ShortList paramShortList);

  public abstract void reportError(String paramString, Object[] paramArrayOfObject);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xerces.internal.impl.xs.identity.ValueStore
 * JD-Core Version:    0.6.2
 */