package javax.accessibility;

public abstract class AccessibleHyperlink
  implements AccessibleAction
{
  public abstract boolean isValid();

  public abstract int getAccessibleActionCount();

  public abstract boolean doAccessibleAction(int paramInt);

  public abstract String getAccessibleActionDescription(int paramInt);

  public abstract Object getAccessibleActionObject(int paramInt);

  public abstract Object getAccessibleActionAnchor(int paramInt);

  public abstract int getStartIndex();

  public abstract int getEndIndex();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.accessibility.AccessibleHyperlink
 * JD-Core Version:    0.6.2
 */