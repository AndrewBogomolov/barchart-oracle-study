package javax.net.ssl;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

public abstract class KeyManagerFactorySpi
{
  protected abstract void engineInit(KeyStore paramKeyStore, char[] paramArrayOfChar)
    throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException;

  protected abstract void engineInit(ManagerFactoryParameters paramManagerFactoryParameters)
    throws InvalidAlgorithmParameterException;

  protected abstract KeyManager[] engineGetKeyManagers();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.net.ssl.KeyManagerFactorySpi
 * JD-Core Version:    0.6.2
 */