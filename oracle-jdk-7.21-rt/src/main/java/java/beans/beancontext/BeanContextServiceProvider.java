package java.beans.beancontext;

import java.util.Iterator;

public abstract interface BeanContextServiceProvider
{
  public abstract Object getService(BeanContextServices paramBeanContextServices, Object paramObject1, Class paramClass, Object paramObject2);

  public abstract void releaseService(BeanContextServices paramBeanContextServices, Object paramObject1, Object paramObject2);

  public abstract Iterator getCurrentServiceSelectors(BeanContextServices paramBeanContextServices, Class paramClass);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.beans.beancontext.BeanContextServiceProvider
 * JD-Core Version:    0.6.2
 */