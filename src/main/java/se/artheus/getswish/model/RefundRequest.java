package se.artheus.getswish.model;

public class RefundRequest {
  private final String payerPaymentReference;
  private final String originalPaymentReference;
  private final String paymentReference;
  private final String callbackUrl;
  private final String payerAlias;
  private final String payeeAlias;
  private final Integer amount;
  private final Currency currency;
  private final String message;

  private RefundRequest(Builder builder) {
    this.payerPaymentReference = builder.payerPaymentReference;
    this.originalPaymentReference = builder.originalPaymentReference;
    this.paymentReference = builder.paymentReference;
    this.callbackUrl = builder.callbackUrl;
    this.payerAlias = builder.payerAlias;
    this.payeeAlias = builder.payeeAlias;
    this.amount = builder.amount;
    this.currency = builder.currency;
    this.message = builder.message;
  }

  public String getPayerPaymentReference() {
    return payerPaymentReference;
  }

  public String getOriginalPaymentReference() {
    return originalPaymentReference;
  }

  public String getPaymentReference() {
    return paymentReference;
  }

  public String getCallbackUrl() {
    return callbackUrl;
  }

  public String getPayerAlias() {
    return payerAlias;
  }

  public String getPayeeAlias() {
    return payeeAlias;
  }

  public Integer getAmount() {
    return amount;
  }

  public Currency getCurrency() {
    return currency;
  }

  public String getMessage() {
    return message;
  }

  public static class Builder {
    private final String originalPaymentReference;
    private final String callbackUrl;
    private final String payerAlias;
    private final Integer amount;
    private final Currency currency;

    private String payerPaymentReference;
    private String paymentReference;
    private String payeeAlias;
    private String message;

    public Builder(String originalPaymentReference, String callbackUrl, String payerAlias, Integer amount, Currency currency) {
      this.originalPaymentReference = originalPaymentReference;
      this.callbackUrl = callbackUrl;
      this.payerAlias = payerAlias;
      this.amount = amount;
      this.currency = currency;
    }

    public Builder withPayerPaymentReference(String payerPaymentReference) {
      this.payerPaymentReference = payerPaymentReference;
      return this;
    }

    public Builder withPaymentReference(String paymentReference) {
      this.paymentReference = paymentReference;
      return this;
    }

    public Builder withPayeeAlias(String payeeAlias) {
      this.payeeAlias = payeeAlias;
      return this;
    }

    public Builder withMessage(String message) {
      this.message = message;
      return this;
    }

    public RefundRequest build() {
      return new RefundRequest(this);
    }
  }
}
