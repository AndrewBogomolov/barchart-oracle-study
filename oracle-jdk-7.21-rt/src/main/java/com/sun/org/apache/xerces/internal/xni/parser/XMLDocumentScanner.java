package com.sun.org.apache.xerces.internal.xni.parser;

import com.sun.org.apache.xerces.internal.xni.XNIException;
import java.io.IOException;

public abstract interface XMLDocumentScanner extends XMLDocumentSource
{
  public abstract void setInputSource(XMLInputSource paramXMLInputSource)
    throws IOException;

  public abstract boolean scanDocument(boolean paramBoolean)
    throws IOException, XNIException;

  public abstract int next()
    throws XNIException, IOException;
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xerces.internal.xni.parser.XMLDocumentScanner
 * JD-Core Version:    0.6.2
 */