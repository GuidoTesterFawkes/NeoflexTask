package yandex.test_cases;

import org.junit.Test;


public class UserCanSendYandexEMailTestCase extends BasicYandexTestCase {
  /**
   * 1.Send an email.
   * Sends an email with subject defined as "Subject" by default (see implementation for details).
   * The email is send to the sender *self (origin and destination emails are the same email).
   */
  @Test
  public void userCanSendEmail() {
    loginAccount()
            .writeAnEmail()
            .typeDestination(getLogin())
            .typeSubject("Subject")
            .send()
            .waitForMailHaveBeenSentMessage();
  }
}
