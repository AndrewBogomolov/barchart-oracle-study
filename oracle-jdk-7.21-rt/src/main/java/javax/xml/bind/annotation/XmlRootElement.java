package javax.xml.bind.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface XmlRootElement
{
  public abstract String namespace();

  public abstract String name();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.xml.bind.annotation.XmlRootElement
 * JD-Core Version:    0.6.2
 */