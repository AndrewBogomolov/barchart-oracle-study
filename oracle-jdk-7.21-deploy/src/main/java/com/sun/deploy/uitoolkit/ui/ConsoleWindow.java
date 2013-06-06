package com.sun.deploy.uitoolkit.ui;

public abstract interface ConsoleWindow
{
  public static final int TEXT_LIMIT = 1048575;

  public abstract void dispose();

  public abstract void append(String paramString);

  public abstract void clear();

  public abstract void setTitle(String paramString);

  public abstract void setVisible(boolean paramBoolean);

  public abstract boolean isVisible();

  public abstract String getRecentLog();
}

/* Location:           /home/user1/Temp/jvm/deploy.jar
 * Qualified Name:     com.sun.deploy.uitoolkit.ui.ConsoleWindow
 * JD-Core Version:    0.6.2
 */