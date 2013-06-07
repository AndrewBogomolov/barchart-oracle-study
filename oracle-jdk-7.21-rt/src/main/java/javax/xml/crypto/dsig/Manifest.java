package javax.xml.crypto.dsig;

import java.util.List;
import javax.xml.crypto.XMLStructure;

public abstract interface Manifest extends XMLStructure
{
  public static final String TYPE = "http://www.w3.org/2000/09/xmldsig#Manifest";

  public abstract String getId();

  public abstract List getReferences();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.xml.crypto.dsig.Manifest
 * JD-Core Version:    0.6.2
 */