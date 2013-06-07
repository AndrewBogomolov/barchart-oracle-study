package javax.jws;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD})
public @interface HandlerChain
{
  public abstract String file();

  @Deprecated
  public abstract String name();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.jws.HandlerChain
 * JD-Core Version:    0.6.2
 */