package se.artheus.getswish.model;

import se.artheus.getswish.error.PaymentErrorCodes;

import java.time.LocalDateTime;

/*
SUCCESS:
curl -v --request GET
https://mss.swicpc.bankgirot.se/swish-cpcapi/api/v1/paymentrequests/AB23D7406ECE4542A80152D909EF9F6B
< HTTP/1.1 200 OK
{
"id": "AB23D7406ECE4542A80152D909EF9F6B",
"payeePaymentReference": "0123456789",
"paymentReference": "6D6CD7406ECE4542A80152D909EF9F6B",
"callbackUrl": "https://example.com/api/swishcb/paymentrequests",
"payerAlias": "07211234567",
"payeeAlias": "1231234567890",
"amount": "100",
"currency": "SEK",
"message": "Kingston USB Flash Drive 8 GB",
"status": "PAID",
"dateCreated": "2015-02-19T22:01:53+01:00",
"datePaid": "2015-02-19T22:03:53+01:00"
}

WITH ERROR:
curl -v --request GET
https://mss.swicpc.bankgirot.se/swish-cpcapi/api/v1/paymentrequests/88C45305089D4186BD4AC141D0911D55
< HTTP/1.1 200 OK
{
"id":"88C45305089D4186BD4AC141D0911D55",
"payeePaymentReference":"0123456789",
"paymentReference":null,
"callbackUrl":"https://example.com/api/swishcb/paymentrequests",
"payerAlias":null,
"payeeAlias":"1231181189",
"amount":100.00,
"currency":"SEK",
"message":"AC05",
"status":"ERROR",
"dateCreated":"2015-10-20T10:01:31.784Z",
"datePaid":null,
"errorCode":"AC05",
"errorMessage":"Payers bank account is closed"
}
 */
public class PaymentConfirmationResponse {
  private String id;
  private String payeePaymentReference;
  private String paymentReference;
  private String callbackUrl;
  private String payerAlias;
  private String payeeAlias;
  private Integer amount;
  private Currency currency;
  private String message;
  private PaymentStatus status;
  private LocalDateTime dateCreated;
  private LocalDateTime datePaid;
  private PaymentErrorCodes errorCode;
  private String errorMessage;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPayeePaymentReference() {
    return payeePaymentReference;
  }

  public void setPayeePaymentReference(String payeePaymentReference) {
    this.payeePaymentReference = payeePaymentReference;
  }

  public String getPaymentReference() {
    return paymentReference;
  }

  public void setPaymentReference(String paymentReference) {
    this.paymentReference = paymentReference;
  }

  public String getCallbackUrl() {
    return callbackUrl;
  }

  public void setCallbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
  }

  public String getPayerAlias() {
    return payerAlias;
  }

  public void setPayerAlias(String payerAlias) {
    this.payerAlias = payerAlias;
  }

  public String getPayeeAlias() {
    return payeeAlias;
  }

  public void setPayeeAlias(String payeeAlias) {
    this.payeeAlias = payeeAlias;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public PaymentStatus getStatus() {
    return status;
  }

  public void setStatus(PaymentStatus status) {
    this.status = status;
  }

  public LocalDateTime getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(LocalDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }

  public LocalDateTime getDatePaid() {
    return datePaid;
  }

  public void setDatePaid(LocalDateTime datePaid) {
    this.datePaid = datePaid;
  }

  public PaymentErrorCodes getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(PaymentErrorCodes errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
}
