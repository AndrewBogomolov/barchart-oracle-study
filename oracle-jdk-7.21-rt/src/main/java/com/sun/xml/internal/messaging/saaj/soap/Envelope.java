package com.sun.xml.internal.messaging.saaj.soap;

import java.io.IOException;
import java.io.OutputStream;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.transform.Source;

public abstract interface Envelope extends SOAPEnvelope
{
  public abstract Source getContent();

  public abstract void output(OutputStream paramOutputStream)
    throws IOException;

  public abstract void output(OutputStream paramOutputStream, boolean paramBoolean)
    throws IOException;
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.messaging.saaj.soap.Envelope
 * JD-Core Version:    0.6.2
 */