package javax.jws;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface WebResult
{
  public abstract String name();

  public abstract String partName();

  public abstract String targetNamespace();

  public abstract boolean header();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.jws.WebResult
 * JD-Core Version:    0.6.2
 */