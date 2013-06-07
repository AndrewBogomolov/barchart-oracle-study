package javax.xml.ws;

import java.security.Principal;
import javax.xml.ws.handler.MessageContext;
import org.w3c.dom.Element;

public abstract interface WebServiceContext
{
  public abstract MessageContext getMessageContext();

  public abstract Principal getUserPrincipal();

  public abstract boolean isUserInRole(String paramString);

  public abstract EndpointReference getEndpointReference(Element[] paramArrayOfElement);

  public abstract <T extends EndpointReference> T getEndpointReference(Class<T> paramClass, Element[] paramArrayOfElement);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.xml.ws.WebServiceContext
 * JD-Core Version:    0.6.2
 */