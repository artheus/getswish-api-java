package se.artheus.getswish.error;

/*
curl -v --request POST https://mss.swicpc.bankgirot.se/swish- cpcapi/api/v1/paymentrequests/ \
--header "Content-Type: application/json" \
--data @- <<!
{
"payeePaymentReference": "0123456789",
"callbackUrl": "https://example.com/api/swishcb/paymentrequests",
"payeeAlias": "1231181189",
"amount": "100", "currency": "SEK", "message": "BE18"
}
!
< HTTP/1.1 422 Unprocessable Entity
< Content-Type: application/json
< Transfer-Encoding: chunked
<
[{"errorCode":"BE18","errorMessage":"In this case incorrect MSISDN","additionalInformation":null}]
 */
public class ErrorResponse {
  private final PaymentErrorCodes errorCode;
  private final String errorMessage;
  private final String additionalInformation;

  public ErrorResponse(PaymentErrorCodes errorCode, String errorMessage, String additionalInformation) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
    this.additionalInformation = additionalInformation;
  }

  public PaymentErrorCodes getErrorCode() {
    return errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public String getAdditionalInformation() {
    return additionalInformation;
  }
}
