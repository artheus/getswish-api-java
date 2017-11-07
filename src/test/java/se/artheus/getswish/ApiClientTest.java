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

    PaymentRequest request = new PaymentRequest.Builder(
        "https://example.com/api/swishcb/paymentrequests",
        "1231181189",
        100,
        Currency.SEK
    ).withMessage("Kingston USB Flash Drive 8 GB").withPayeePaymentReference("0123456789").build();

    PaymentResponse response = client.requestPayment(request);
    System.out.println(response.getLocation());
    System.out.println(response.getPaymentRequestToken());
  }

  @Test
  public void testRequestRefund() throws JsonProcessingException {
    ApiClient client = new ApiClient();

    RefundRequest request = new RefundRequest.Builder(
        "0123456789",
        "https://example.com/api/swishcb/paymentrequests",
        "1231181189",
        179,
        Currency.SEK
    ).withMessage("Kingston USB Flash Drive 16 GB").withPayeeAlias("1231181189").build();

    RefundResponse response = client.requestRefund(request);
    System.out.println(response.getLocation());
  }
}