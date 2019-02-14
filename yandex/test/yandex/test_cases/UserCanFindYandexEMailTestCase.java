package yandex.test_cases;

import org.junit.Test;


public class UserCanFindYandexEMailTestCase extends BasicYandexTestCase {
  /**
   * 4.Find an email with subject defined as "Subject" (see implementation for details),
   * fails if there is no any email with such subject,
   * otherwise clicks on found email.
  */
  @Test
  public void userCanFindEmail() {
    loginAccount()
            .findAnEmail("Subject")
            .clickOnTopMail();
  }
}
