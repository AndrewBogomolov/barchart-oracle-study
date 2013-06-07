package javax.xml.crypto.dsig.keyinfo;

import java.util.List;
import javax.xml.crypto.XMLStructure;

public abstract interface PGPData extends XMLStructure
{
  public static final String TYPE = "http://www.w3.org/2000/09/xmldsig#PGPData";

  public abstract byte[] getKeyId();

  public abstract byte[] getKeyPacket();

  public abstract List getExternalElements();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.xml.crypto.dsig.keyinfo.PGPData
 * JD-Core Version:    0.6.2
 */