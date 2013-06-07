package com.sun.xml.internal.ws.api.server;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InstanceResolverAnnotation
{
  public abstract Class<? extends InstanceResolver> value();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.ws.api.server.InstanceResolverAnnotation
 * JD-Core Version:    0.6.2
 */