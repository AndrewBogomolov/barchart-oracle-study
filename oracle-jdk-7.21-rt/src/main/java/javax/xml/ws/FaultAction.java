package javax.xml.ws;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface FaultAction
{
  public abstract Class<? extends Exception> className();

  public abstract String value();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.xml.ws.FaultAction
 * JD-Core Version:    0.6.2
 */