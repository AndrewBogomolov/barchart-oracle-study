package com.sun.xml.internal.ws.developer;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.xml.ws.spi.WebServiceFeatureAnnotation;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD})
@Documented
@WebServiceFeatureAnnotation(id="http://jax-ws.dev.java.net/features/schema-validation", bean=SchemaValidationFeature.class)
public @interface SchemaValidation
{
  public abstract Class<? extends ValidationErrorHandler> handler();

  public abstract boolean inbound();

  public abstract boolean outbound();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.ws.developer.SchemaValidation
 * JD-Core Version:    0.6.2
 */