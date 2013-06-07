package com.sun.xml.internal.bind.api;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public abstract interface ErrorListener extends ErrorHandler
{
  public abstract void error(SAXParseException paramSAXParseException);

  public abstract void fatalError(SAXParseException paramSAXParseException);

  public abstract void warning(SAXParseException paramSAXParseException);

  public abstract void info(SAXParseException paramSAXParseException);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.bind.api.ErrorListener
 * JD-Core Version:    0.6.2
 */