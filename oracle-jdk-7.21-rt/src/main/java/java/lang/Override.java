package java.lang;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface Override
{
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.lang.Override
 * JD-Core Version:    0.6.2
 */