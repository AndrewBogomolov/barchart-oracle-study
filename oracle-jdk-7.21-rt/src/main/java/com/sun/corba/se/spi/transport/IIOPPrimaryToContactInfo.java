package com.sun.corba.se.spi.transport;

import com.sun.corba.se.pept.transport.ContactInfo;
import java.util.List;

public abstract interface IIOPPrimaryToContactInfo
{
  public abstract void reset(ContactInfo paramContactInfo);

  public abstract boolean hasNext(ContactInfo paramContactInfo1, ContactInfo paramContactInfo2, List paramList);

  public abstract ContactInfo next(ContactInfo paramContactInfo1, ContactInfo paramContactInfo2, List paramList);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.corba.se.spi.transport.IIOPPrimaryToContactInfo
 * JD-Core Version:    0.6.2
 */