package com.sun.corba.se.spi.transport;

import com.sun.corba.se.pept.transport.ContactInfoListIterator;
import com.sun.corba.se.spi.ior.IOR;

public abstract interface CorbaContactInfoListIterator extends ContactInfoListIterator
{
  public abstract void reportAddrDispositionRetry(CorbaContactInfo paramCorbaContactInfo, short paramShort);

  public abstract void reportRedirect(CorbaContactInfo paramCorbaContactInfo, IOR paramIOR);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.corba.se.spi.transport.CorbaContactInfoListIterator
 * JD-Core Version:    0.6.2
 */