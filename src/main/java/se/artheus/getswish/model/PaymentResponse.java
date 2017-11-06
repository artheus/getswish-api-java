package se.artheus.getswish.model;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public class PaymentResponse {

  private final ResponseEntity<String> entity;

  public PaymentResponse(ResponseEntity<String> entity) {
    this.entity = entity;
  }

  public String getLocation() {
    return this.getHeaders().get("Location").get(0);
  }

  public String getPaymentRequestToken() {
    return this.getHeaders().get("PaymentRequestToken").get(0);
  }

  public HttpHeaders getHeaders() {
    return entity.getHeaders();
  }
}
