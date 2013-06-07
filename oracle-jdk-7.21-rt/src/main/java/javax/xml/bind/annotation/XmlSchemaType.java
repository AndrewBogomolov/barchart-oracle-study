package javax.xml.bind.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PACKAGE})
public @interface XmlSchemaType
{
  public abstract String name();

  public abstract String namespace();

  public abstract Class type();

  public static final class DEFAULT
  {
  }
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.xml.bind.annotation.XmlSchemaType
 * JD-Core Version:    0.6.2
 */