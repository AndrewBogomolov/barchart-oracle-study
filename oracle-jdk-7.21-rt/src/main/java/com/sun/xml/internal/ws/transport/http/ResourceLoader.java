package com.sun.xml.internal.ws.transport.http;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public abstract interface ResourceLoader
{
  public abstract URL getResource(String paramString)
    throws MalformedURLException;

  public abstract URL getCatalogFile()
    throws MalformedURLException;

  public abstract Set<String> getResourcePaths(String paramString);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.ws.transport.http.ResourceLoader
 * JD-Core Version:    0.6.2
 */