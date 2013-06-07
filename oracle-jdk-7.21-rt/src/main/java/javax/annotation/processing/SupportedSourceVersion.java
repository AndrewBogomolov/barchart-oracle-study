package javax.annotation.processing;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.lang.model.SourceVersion;

@Documented
@Target({java.lang.annotation.ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SupportedSourceVersion
{
  public abstract SourceVersion value();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.annotation.processing.SupportedSourceVersion
 * JD-Core Version:    0.6.2
 */