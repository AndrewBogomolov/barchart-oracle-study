package com.sun.tracing.dtrace;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface ModuleName
{
  public abstract String value();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.tracing.dtrace.ModuleName
 * JD-Core Version:    0.6.2
 */