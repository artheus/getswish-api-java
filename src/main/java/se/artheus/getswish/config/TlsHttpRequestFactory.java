package se.artheus.getswish.config;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public class TlsHttpRequestFactory extends HttpComponentsClientHttpRequestFactory {

  private static KeyStore keyStore;
  private static KeyStore trustStore;

  private static char[] getKeyStorePwd() {
    String keystorePassword = System.getenv("SWISH_KEYSTORE_PWD");

    return keystorePassword.toCharArray();
  }

  private static KeyStore getKeyStore() {
    String keystoreFilename = System.getenv("SWISH_KEYSTORE_FILE");

    try(FileInputStream keystoreInputStream = new FileInputStream(keystoreFilename)) {
      if (keyStore == null) keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      keyStore.load(keystoreInputStream, getKeyStorePwd());
    } catch (IOException | KeyStoreException | CertificateException | NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
    return keyStore;
  }

  private static char[] getTrustStorePwd() {
    String truststorePassword = System.getenv("SWISH_TRUSTSTORE_PWD");

    return truststorePassword.toCharArray();
  }

  private static KeyStore getTrustStore() {
    String truststoreFilename = System.getenv("SWISH_TRUSTSTORE_FILE");

    try (FileInputStream truststoreInputStream = new FileInputStream(truststoreFilename)) {
      if (trustStore == null) trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
      trustStore.load(truststoreInputStream, getTrustStorePwd());
    } catch (CertificateException | NoSuchAlgorithmException | IOException | KeyStoreException e) {
      throw new RuntimeException(e);
    }
    return trustStore;
  }

  public TlsHttpRequestFactory() {
    try {
      SSLContext sslcontext = SSLContexts.custom().setProtocol("TLS")
          .loadKeyMaterial(getKeyStore(), getKeyStorePwd())
          .loadTrustMaterial(getTrustStore(), null).build();

      SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslcontext);

      CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();

      HttpsURLConnection.setDefaultSSLSocketFactory(sslcontext.getSocketFactory());
      this.setHttpClient(httpClient);
    } catch (NoSuchAlgorithmException | KeyManagementException | UnrecoverableKeyException | KeyStoreException e) {
      throw new RuntimeException(e);
    }
  }
}
