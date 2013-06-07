package javax.xml.bind;

import java.net.URL;
import org.w3c.dom.Node;

public abstract interface ValidationEventLocator
{
  public abstract URL getURL();

  public abstract int getOffset();

  public abstract int getLineNumber();

  public abstract int getColumnNumber();

  public abstract Object getObject();

  public abstract Node getNode();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.xml.bind.ValidationEventLocator
 * JD-Core Version:    0.6.2
 */