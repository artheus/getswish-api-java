package se.artheus.getswish.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class ApiResponseErrorHandler implements ResponseErrorHandler {

  private final static Logger log = LoggerFactory.getLogger(ApiResponseErrorHandler.class);

  @Override
  public boolean hasError(ClientHttpResponse response) throws IOException {
    return response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError();
  }

  @Override
  public void handleError(ClientHttpResponse response) throws IOException {
    log.error(response.getStatusCode().toString() + ": " + response.getStatusText());
  }
}
