package se.artheus.getswish;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import se.artheus.getswish.config.TlsHttpRequestFactory;
import se.artheus.getswish.error.ApiResponseErrorHandler;
import se.artheus.getswish.model.PaymentConfirmationResponse;
import se.artheus.getswish.model.PaymentRequest;
import se.artheus.getswish.model.PaymentResponse;
import se.artheus.getswish.model.RefundConfirmationResponse;
import se.artheus.getswish.model.RefundRequest;
import se.artheus.getswish.model.RefundResponse;

import java.util.Collections;
import java.util.HashMap;

public class ApiClient {

  private static final String PAYMENTREQUEST_URL = "HTTPS://mss.swicpc.bankgirot" +
      ".se/swish-cpcapi/api/v1/paymentrequests/";

  private static final ObjectMapper mapper = new ObjectMapper();

  private RestTemplate restTemplate;

  private TlsHttpRequestFactory getHttpRequestFactory() {
    return new TlsHttpRequestFactory();
  }

  private ResponseErrorHandler getResponseErrorHandler() {
    return new ApiResponseErrorHandler();
  }

  private RestTemplate getRestTemplate() {
    if(this.restTemplate == null) {
      this.restTemplate = new RestTemplate(this.getHttpRequestFactory());
      this.restTemplate.setErrorHandler(this.getResponseErrorHandler());
    }

    return this.restTemplate;
  }

  private HttpHeaders getDefaultHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.setContentType(MediaType.APPLICATION_JSON);

    return headers;
  }

  public PaymentResponse requestPayment(PaymentRequest request) throws JsonProcessingException {
    HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(request), getDefaultHeaders());

    return new PaymentResponse( getRestTemplate()
        .postForEntity(PAYMENTREQUEST_URL, entity, String.class, new HashMap<String, String>()) );
  }

  public PaymentConfirmationResponse getPaymentConfirmation(String location) {
    return getRestTemplate().getForObject(location, PaymentConfirmationResponse.class, new HashMap<String, String>());
  }

  public RefundResponse requestRefund(RefundRequest request) throws JsonProcessingException {
    HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(request), getDefaultHeaders());

    return new RefundResponse( getRestTemplate()
        .postForEntity(PAYMENTREQUEST_URL, entity, String.class, new HashMap<String, String>()) );
  }

  public RefundConfirmationResponse getRefundConfirmation(String location) {
    return getRestTemplate().getForObject(location, RefundConfirmationResponse.class, new HashMap<String, String>());
  }
}
