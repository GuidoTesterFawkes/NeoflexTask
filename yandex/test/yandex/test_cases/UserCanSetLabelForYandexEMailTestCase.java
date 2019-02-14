package yandex.test_cases;

import org.junit.Test;


public class UserCanSetLabelForYandexEMailTestCase extends BasicYandexTestCase {
  /**
   * 5.Set label "Избранное" to the newest email with subject defined as "Subject" (see implementation for details),
   * fails if there is no any email with such subject,
   * otherwise sets the label.
  */
  @Test
  public void userCanSetLabelForEmail() {
    loginAccount()
            .clickMailsWithSameSubject("Subject")
            .clickTopEmail()
            .setLabel("Избранное");
  }
}
