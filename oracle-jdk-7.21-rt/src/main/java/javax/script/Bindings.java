package javax.script;

import java.util.Map;

public abstract interface Bindings extends Map<String, Object>
{
  public abstract Object put(String paramString, Object paramObject);

  public abstract void putAll(Map<? extends String, ? extends Object> paramMap);

  public abstract boolean containsKey(Object paramObject);

  public abstract Object get(Object paramObject);

  public abstract Object remove(Object paramObject);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.script.Bindings
 * JD-Core Version:    0.6.2
 */