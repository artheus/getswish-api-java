package se.artheus.getswish.error;

public enum RefundErrorCodes {
  FF08("PayerPaymentReference is invalid"),
  RP03("Callback URL is missing or does not use Https"),
  PA02("Amount value is missing or not a valid number"),
  AM06("Amount value is too low"),
  RF08("Amount value is too large or amount exceeds the amount of the original payment minus any previous refunds. " +
      "Note: the remaining available amount is put into the additional information field."),
  AM03("Invalid or missing Currency"),
  RP01("Payer alias is missing or empty"),
  RP02("Invalid Message text"),
  ACMT07("Payee not Enrolled"),
  ACMT01("Counterpart is not activated"),
  RF02("Original Payment not found or original payment is more than than 13 months old"),
  RF03("Payer alias in the refund does not match the payee alias in the original payment."),
  RF04("Payer organization number does not match original payment payee organization number."),
  RF06("The Payee SSN (personnummer) in the original payment is not the same as the SSN for the current Payee. Note:" +
      " Typically this means that the Mobile number has been transferred to another person."),
  RF07("Transaction declined"),
  FF10("Bank system processing error"),
  BE18("Invalid contact details error"),
  DS24("Swish timed out waiting for an answer from the banks after payment was started." +
       "Note: If this happens Swish has no knowledge of whether the payment was successful or not. The Merchant " +
       "should inform its consumer about this and recommend them to check with their bank about the status of this")
  ;

  private final String description;

  RefundErrorCodes(String desc) {
    this.description = desc;
  }

  public String getDescription() {
    return description;
  }
}
