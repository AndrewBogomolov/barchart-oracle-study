package com.sun.org.glassfish.gmbal;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD})
public @interface DescriptorKey
{
  public abstract String value();

  public abstract boolean omitIfDefault();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.glassfish.gmbal.DescriptorKey
 * JD-Core Version:    0.6.2
 */