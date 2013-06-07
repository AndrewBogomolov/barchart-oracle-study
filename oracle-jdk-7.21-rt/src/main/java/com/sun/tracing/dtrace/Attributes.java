package com.sun.tracing.dtrace;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface Attributes
{
  public abstract StabilityLevel name();

  public abstract StabilityLevel data();

  public abstract DependencyClass dependency();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.tracing.dtrace.Attributes
 * JD-Core Version:    0.6.2
 */