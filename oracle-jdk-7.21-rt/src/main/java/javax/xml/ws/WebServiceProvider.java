package javax.xml.ws;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebServiceProvider
{
  public abstract String wsdlLocation();

  public abstract String serviceName();

  public abstract String targetNamespace();

  public abstract String portName();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.xml.ws.WebServiceProvider
 * JD-Core Version:    0.6.2
 */