package java.rmi.registry;

import java.rmi.RemoteException;
import java.rmi.UnknownHostException;

@Deprecated
public abstract interface RegistryHandler
{
  @Deprecated
  public abstract Registry registryStub(String paramString, int paramInt)
    throws RemoteException, UnknownHostException;

  @Deprecated
  public abstract Registry registryImpl(int paramInt)
    throws RemoteException;
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.rmi.registry.RegistryHandler
 * JD-Core Version:    0.6.2
 */