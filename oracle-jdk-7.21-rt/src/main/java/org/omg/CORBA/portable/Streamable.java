package org.omg.CORBA.portable;

import org.omg.CORBA.TypeCode;

public abstract interface Streamable
{
  public abstract void _read(InputStream paramInputStream);

  public abstract void _write(OutputStream paramOutputStream);

  public abstract TypeCode _type();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     org.omg.CORBA.portable.Streamable
 * JD-Core Version:    0.6.2
 */