package com.sun.net.httpserver;

import java.util.List;
import java.util.Map;

public abstract class HttpContext
{
  public abstract HttpHandler getHandler();

  public abstract void setHandler(HttpHandler paramHttpHandler);

  public abstract String getPath();

  public abstract HttpServer getServer();

  public abstract Map<String, Object> getAttributes();

  public abstract List<Filter> getFilters();

  public abstract Authenticator setAuthenticator(Authenticator paramAuthenticator);

  public abstract Authenticator getAuthenticator();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.net.httpserver.HttpContext
 * JD-Core Version:    0.6.2
 */