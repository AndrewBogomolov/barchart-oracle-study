package com.sun.xml.internal.bind.v2.schemagen.xmlschema;

import com.sun.xml.internal.txw2.TypedXmlWriter;
import com.sun.xml.internal.txw2.annotation.XmlAttribute;

public abstract interface FixedOrDefault extends TypedXmlWriter
{
  @XmlAttribute("default")
  public abstract FixedOrDefault _default(String paramString);

  @XmlAttribute
  public abstract FixedOrDefault fixed(String paramString);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.bind.v2.schemagen.xmlschema.FixedOrDefault
 * JD-Core Version:    0.6.2
 */