package javax.xml.bind.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.PACKAGE})
public @interface XmlSchema
{
  public static final String NO_LOCATION = "##generate";

  public abstract XmlNs[] xmlns();

  public abstract String namespace();

  public abstract XmlNsForm elementFormDefault();

  public abstract XmlNsForm attributeFormDefault();

  public abstract String location();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.xml.bind.annotation.XmlSchema
 * JD-Core Version:    0.6.2
 */