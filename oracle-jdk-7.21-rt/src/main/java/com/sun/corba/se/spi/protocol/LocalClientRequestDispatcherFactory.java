package com.sun.corba.se.spi.protocol;

import com.sun.corba.se.spi.ior.IOR;

public abstract interface LocalClientRequestDispatcherFactory
{
  public abstract LocalClientRequestDispatcher create(int paramInt, IOR paramIOR);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.corba.se.spi.protocol.LocalClientRequestDispatcherFactory
 * JD-Core Version:    0.6.2
 */