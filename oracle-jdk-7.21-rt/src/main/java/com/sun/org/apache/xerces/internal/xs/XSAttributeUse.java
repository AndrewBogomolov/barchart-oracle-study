package com.sun.org.apache.xerces.internal.xs;

public abstract interface XSAttributeUse extends XSObject
{
  public abstract boolean getRequired();

  public abstract XSAttributeDeclaration getAttrDeclaration();

  public abstract short getConstraintType();

  public abstract String getConstraintValue();

  public abstract Object getActualVC()
    throws XSException;

  public abstract short getActualVCType()
    throws XSException;

  public abstract ShortList getItemValueTypes()
    throws XSException;

  public abstract XSObjectList getAnnotations();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xerces.internal.xs.XSAttributeUse
 * JD-Core Version:    0.6.2
 */