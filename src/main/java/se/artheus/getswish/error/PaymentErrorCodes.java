package se.artheus.getswish.error;

public enum PaymentErrorCodes {
  /**
   * Potential Error codes which can be set on Create payment request ‘description’ to simulate validation failure in the
   * “Payment request created” response (HTTP status code 422 is returned for the first answer)
   */
  FF08("PayeePaymentReference is invalid"),
  RP03("Callback URL is missing or does not use Https"),
  BE18("Payer alias is invalid"),
  RP01("Payee alias is missing or empty"),
  PA02("Amount value is missing or not a valid number"),
  AM06("Amount value is too low"),
  AM02("Amount value is too large"),
  AM03("Invalid or missing Currency"),
  RP02("Wrong formatted description"),
  RP06("Another active PaymentRequest already exists for this payerAlias. Only applicable for E-Commerce."),
  ACMT03("Payer not Enrolled"),
  ACMT01("Counterpart is not activated"),
  ACMT07("Payee not Enrolled"),

  /**
   * Potential Error codes which can be set on Create payment request ‘description’ to simulate failed
   * “Payment confirmation” (HTTP status code 422 is returned for the second answer):
   */
  RF07("Transaction declined"),
  BANKIDCL("Payer cancelled BankId signing"),
  FF10("Bank system processing error"),
  TM01("Swish timed out before the payment was started"),
  DS24("Swish timed out waiting for an answer from the banks after payment was started."+
       " Note: If this happens Swish has no knowledge of whether the payment was successful or not. The Merchant " +
       "should inform its consumer about this and recommend them to check with their bank about the status of this " +
       "payment.")
  ;

  private final String description;

  PaymentErrorCodes(String desc) {
    this.description = desc;
  }

  public String getDescription() {
    return description;
  }
}
