package com.sun.java.browser.dom;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

public abstract interface DOMAccessor
{
  public abstract Document getDocument(Object paramObject)
    throws DOMException;

  public abstract DOMImplementation getDOMImplementation();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.java.browser.dom.DOMAccessor
 * JD-Core Version:    0.6.2
 */