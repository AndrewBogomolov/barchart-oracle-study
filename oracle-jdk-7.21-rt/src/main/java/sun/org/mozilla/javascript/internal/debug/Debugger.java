package sun.org.mozilla.javascript.internal.debug;

import sun.org.mozilla.javascript.internal.Context;

public abstract interface Debugger
{
  public abstract void handleCompilationDone(Context paramContext, DebuggableScript paramDebuggableScript, String paramString);

  public abstract DebugFrame getFrame(Context paramContext, DebuggableScript paramDebuggableScript);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.org.mozilla.javascript.internal.debug.Debugger
 * JD-Core Version:    0.6.2
 */