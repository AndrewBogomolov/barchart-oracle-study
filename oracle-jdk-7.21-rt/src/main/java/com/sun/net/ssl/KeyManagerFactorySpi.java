package com.sun.net.ssl;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

@Deprecated
public abstract class KeyManagerFactorySpi
{
  protected abstract void engineInit(KeyStore paramKeyStore, char[] paramArrayOfChar)
    throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException;

  protected abstract KeyManager[] engineGetKeyManagers();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.net.ssl.KeyManagerFactorySpi
 * JD-Core Version:    0.6.2
 */