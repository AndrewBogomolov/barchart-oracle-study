package javax.xml.soap;

import java.util.Iterator;
import javax.xml.namespace.QName;

public abstract interface Detail extends SOAPFaultElement
{
  public abstract DetailEntry addDetailEntry(Name paramName)
    throws SOAPException;

  public abstract DetailEntry addDetailEntry(QName paramQName)
    throws SOAPException;

  public abstract Iterator getDetailEntries();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.xml.soap.Detail
 * JD-Core Version:    0.6.2
 */