package com.sun.java.browser.dom;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

public abstract class DOMServiceProvider
{
  public abstract boolean canHandle(Object paramObject);

  public abstract Document getDocument(Object paramObject)
    throws DOMUnsupportedException;

  public abstract DOMImplementation getDOMImplementation();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.java.browser.dom.DOMServiceProvider
 * JD-Core Version:    0.6.2
 */