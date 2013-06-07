package com.sun.xml.internal.bind.v2.model.core;

import javax.xml.namespace.QName;

public abstract interface TypeRef<T, C> extends NonElementRef<T, C>
{
  public abstract QName getTagName();

  public abstract boolean isNillable();

  public abstract String getDefaultValue();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.bind.v2.model.core.TypeRef
 * JD-Core Version:    0.6.2
 */