package yandex.test_cases;

import org.junit.Test;

public class UserCanDeleteYandexEMailTestCase extends BasicYandexTestCase {
  /**
   * 2.Delete one newest email with subject defined as "Subject" (see implementation for details),
   * fails if there is no any email with such subject, otherwise deletes one the newest email.
   * - Uncompleted, cos of deletion exactly a last email instead of an any one email on demand.
   * + Completed, cos already fits into technical requirements of a task, so user really can delete an email.
   *
  */
  @Test
  public void userCanDeleteEmail() {
    loginAccount()
            .clickMailsWithSameSubject("Subject")
            .clickTopEmail()
            .delete();
  }
}
