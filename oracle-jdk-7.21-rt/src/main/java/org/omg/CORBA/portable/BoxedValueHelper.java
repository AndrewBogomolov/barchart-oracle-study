package org.omg.CORBA.portable;

import java.io.Serializable;

public abstract interface BoxedValueHelper
{
  public abstract Serializable read_value(InputStream paramInputStream);

  public abstract void write_value(OutputStream paramOutputStream, Serializable paramSerializable);

  public abstract String get_id();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     org.omg.CORBA.portable.BoxedValueHelper
 * JD-Core Version:    0.6.2
 */