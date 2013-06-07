package javax.security.sasl;

import java.util.Map;
import javax.security.auth.callback.CallbackHandler;

public abstract interface SaslServerFactory
{
  public abstract SaslServer createSaslServer(String paramString1, String paramString2, String paramString3, Map<String, ?> paramMap, CallbackHandler paramCallbackHandler)
    throws SaslException;

  public abstract String[] getMechanismNames(Map<String, ?> paramMap);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.security.sasl.SaslServerFactory
 * JD-Core Version:    0.6.2
 */