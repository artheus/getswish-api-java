package se.artheus.getswish.model;

/*
curl -v --request POST https://mss.swicpc.bankgirot.se/swish- cpcapi/api/v1/paymentrequests \
--header "Content-Type: application/json"
--data @- <<!
{
"payeePaymentReference": "0123456789",
"callbackUrl": "https://example.com/api/swishcb/paymentrequests",
"payerAlias": "4671234768",
"payeeAlias": "1231181189",
"amount": "100", "currency": "SEK",
"message": "Kingston USB Flash Drive 8 GB"
} !
< HTTP/1.1 201 Created
< Location:
https://mss.swicpc.bankgirot.se/swish- cpcapi/v1/paymentrequests/AB23D7406ECE4542A80152D909EF9F6B
 */

public class PaymentRequest {

  private final String payeePaymentReference;
  private final String callbackUrl;
  private final String payerAlias;
  private final String payeeAlias;
  private final Integer amount;
  private final Currency currency;
  private final String message;

  private PaymentRequest(Builder builder) {
    this.payeePaymentReference = builder.payeePaymentReference;
    this.callbackUrl = builder.callbackUrl;
    this.payerAlias = builder.payerAlias;
    this.payeeAlias = builder.payeeAlias;
    this.amount = builder.amount;
    this.currency = builder.currency;
    this.message = builder.message;
  }

  public String getPayeePaymentReference() {
    return payeePaymentReference;
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
    private final String callbackUrl;
    private final String payeeAlias;
    private final Integer amount;
    private final Currency currency;

    private String payeePaymentReference;
    private String payerAlias;
    private String message;

    Builder(String callbackUrl, String payeeAlias, Integer amount, Currency currency) {
      this.callbackUrl = callbackUrl;
      this.payeeAlias = payeeAlias;
      this.amount = amount;
      this.currency = currency;
    }

    public Builder withPayeePaymentReference(String reference) {
      this.payeePaymentReference = reference;
      return this;
    }

    public Builder withPayerAlias(String alias) {
      this.payerAlias = alias;
      return this;
    }

    public Builder withMessage(String message) {
      this.message = message;
      return this;
    }

    public PaymentRequest build() {
      return new PaymentRequest(this);
    }
  }
}
