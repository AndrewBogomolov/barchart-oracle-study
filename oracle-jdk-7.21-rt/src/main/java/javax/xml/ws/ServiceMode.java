package javax.xml.ws;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ServiceMode
{
  public abstract Service.Mode value();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.xml.ws.ServiceMode
 * JD-Core Version:    0.6.2
 */