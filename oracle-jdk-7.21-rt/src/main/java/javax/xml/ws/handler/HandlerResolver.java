package javax.xml.ws.handler;

import java.util.List;

public abstract interface HandlerResolver
{
  public abstract List<Handler> getHandlerChain(PortInfo paramPortInfo);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.xml.ws.handler.HandlerResolver
 * JD-Core Version:    0.6.2
 */