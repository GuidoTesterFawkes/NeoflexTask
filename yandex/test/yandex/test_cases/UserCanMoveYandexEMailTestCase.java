package yandex.test_cases;

import org.junit.Test;
import yandex.page_objects.AllEmailsPage;

import static yandex.page_objects.BasicPageObject.elementByText;



public class UserCanMoveYandexEMailTestCase extends BasicYandexTestCase {
  /**
   * 3.Check if user can move email.
   * There is an ambiguity what does it exactly mean "move an email",
   * so for this reason this method has two implementations,
   * with moving an email into a folder (actually is commented out)
   * and with drag-and-dropping an email into a different section (actually into the "Отправленные" section).
   * The last version is uncommented for now.
   *
   * Note: there are two possible implementation of the method, so,
   * depending on your assumptions and expectations, you have to invoke one of dragAndDropImplementation or
   * moveToAFolderImplementation method (mutually exclusively).
   *
   * See also: dragAndDropImplementation and moveToAFolderImplementation.
  */
  @Test
  public void userCanMoveEmail() {
    //NOTE: You have to use only one of these two methods, depending on your needs.
    //Wrap one with comments, and unwrap from comments other, that you would like to use.

    moveToAFolderImplementation(loginAccount().clickMailsWithSameSubject("Subject"));
    /*dragAndDropImplementation(loginAccount().clickMailsWithSameSubject("Subject"));*/ //< This method isn't buggy, it is wrapped with comments by other reason
  }

  /**
   * A first of two possible implementations of a testcase method.
   * Usage: May be used in a userCanMoveEmail method like
   * dragAndDropImplementation(loginAccount().clickMailsWithSameSubject("Subject")) invoke
   * mutually exclusively to moveToAFolderImplementation(loginAccount().clickMailsWithSameSubject("Subject")).
   */
  void dragAndDropImplementation(AllEmailsPage defaultPage){
    defaultPage
            //NOTE(V_SUVOROV): This is an extension point, not an architectural issue,
            //that we send an element to a following method
            .dragAndDropTopMailTo(elementByText("Отправленные"));
  }

  /**
   * A second of two possible implementations of a testcase method.
   * Usage: May be used in a userCanMoveEmail method like
   * moveToAFolderImplementation(loginAccount().clickMailsWithSameSubject("Subject")) invoke
   * mutually exclusively to dragAndDropImplementation(loginAccount().clickMailsWithSameSubject("Subject")).
   */
  void moveToAFolderImplementation(AllEmailsPage defaultPage){
    defaultPage
            .clickTopEmail()
            .toFolder("Folder");
  }
}
