package com.sun.xml.internal.ws.api.server;

import com.sun.istack.internal.NotNull;
import javax.xml.ws.WebServiceContext;

public abstract interface AsyncProvider<T>
{
  public abstract void invoke(@NotNull T paramT, @NotNull AsyncProviderCallback<T> paramAsyncProviderCallback, @NotNull WebServiceContext paramWebServiceContext);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.ws.api.server.AsyncProvider
 * JD-Core Version:    0.6.2
 */