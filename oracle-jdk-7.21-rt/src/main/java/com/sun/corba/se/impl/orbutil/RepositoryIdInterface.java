package com.sun.corba.se.impl.orbutil;

import java.net.MalformedURLException;

public abstract interface RepositoryIdInterface
{
  public abstract Class getClassFromType()
    throws ClassNotFoundException;

  public abstract Class getClassFromType(String paramString)
    throws ClassNotFoundException, MalformedURLException;

  public abstract Class getClassFromType(Class paramClass, String paramString)
    throws ClassNotFoundException, MalformedURLException;

  public abstract String getClassName();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.corba.se.impl.orbutil.RepositoryIdInterface
 * JD-Core Version:    0.6.2
 */