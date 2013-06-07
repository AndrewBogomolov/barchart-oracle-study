package com.sun.xml.internal.bind.v2.schemagen.xmlschema;

import com.sun.xml.internal.txw2.TypedXmlWriter;
import com.sun.xml.internal.txw2.annotation.XmlAttribute;
import com.sun.xml.internal.txw2.annotation.XmlElement;
import javax.xml.namespace.QName;

@XmlElement("union")
public abstract interface Union extends Annotated, SimpleTypeHost, TypedXmlWriter
{
  @XmlAttribute
  public abstract Union memberTypes(QName[] paramArrayOfQName);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.bind.v2.schemagen.xmlschema.Union
 * JD-Core Version:    0.6.2
 */