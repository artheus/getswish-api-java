package se.artheus.getswish;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import se.artheus.getswish.model.Currency;
import se.artheus.getswish.model.PaymentRequest;
import se.artheus.getswish.model.PaymentResponse;
import se.artheus.getswish.model.RefundRequest;
import se.artheus.getswish.model.RefundResponse;

public class ApiClientTest {

  @Test
  public void testRequestPayment() throws JsonProcessingException {
    ApiClient client = new ApiClient();

    // TODO: create builders for this, to check if mandatory fields are filled or not.
    PaymentRequest request = new PaymentRequest(
        "0123456789",
        "https://example.com/api/swishcb/paymentrequests",
        "1231181189",
        100,
        Currency.SEK,
        "Kingston USB Flash Drive 8 GB"
    );

    PaymentResponse response = client.requestPayment(request);
    System.out.println(response.getLocation());
    System.out.println(response.getPaymentRequestToken());
  }

  @Test
  public void testRequestRefund() throws Exception {
    ApiClient client = new ApiClient();

    // TODO: create builders for this, to check if mandatory fields are filled or not.
    RefundRequest request = new RefundRequest();
    request.setPayerPaymentReference("0123456789");
    request.setCallbackUrl("https://example.com/api/swishcb/paymentrequests");
    request.setPayeeAlias("1231181189");
    request.setAmount(179);
    request.setCurrency(Currency.SEK);
    request.setMessage("Kingston USB Flash Drive 16 GB");

    RefundResponse response = client.requestRefund(request);
    System.out.println(response.getLocation());
  }
}