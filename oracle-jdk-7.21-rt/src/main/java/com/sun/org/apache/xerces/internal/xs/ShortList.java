package com.sun.org.apache.xerces.internal.xs;

import java.util.List;

public abstract interface ShortList extends List
{
  public abstract int getLength();

  public abstract boolean contains(short paramShort);

  public abstract short item(int paramInt)
    throws XSException;
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xerces.internal.xs.ShortList
 * JD-Core Version:    0.6.2
 */