package se.artheus.getswish.model;

public class RefundRequest {
  private String payerPaymentReference;
  private String originalPaymentReference;
  private String paymentReference;
  private String callbackUrl;
  private String payerAlias;
  private String payeeAlias;
  private Integer amount;
  private Currency currency;
  private String message;

  public String getPayerPaymentReference() {
    return payerPaymentReference;
  }

  public void setPayerPaymentReference(String payerPaymentReference) {
    this.payerPaymentReference = payerPaymentReference;
  }

  public String getOriginalPaymentReference() {
    return originalPaymentReference;
  }

  public void setOriginalPaymentReference(String originalPaymentReference) {
    this.originalPaymentReference = originalPaymentReference;
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
}
