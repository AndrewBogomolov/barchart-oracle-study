package javax.xml.ws;

import javax.xml.bind.JAXBContext;
import javax.xml.transform.Source;

public abstract interface LogicalMessage
{
  public abstract Source getPayload();

  public abstract void setPayload(Source paramSource);

  public abstract Object getPayload(JAXBContext paramJAXBContext);

  public abstract void setPayload(Object paramObject, JAXBContext paramJAXBContext);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.xml.ws.LogicalMessage
 * JD-Core Version:    0.6.2
 */