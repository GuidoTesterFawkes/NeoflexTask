package yandex;

import com.codeborne.selenide.SelenideElement;
import org.junit.Ignore;//have been used during writing tests
import org.junit.Test;
import static yandex.Utility.*;


/*NOTE(V_SUVOROV): this is a russian task text
1. Отправка письма с заполненным полем «Тема»
2. Удаление письма
3. Перемещение письма из раздела в раздел
4. Поиск письма
5. Пометить письмо как «избранное»
*/

/**
 * All tests are written here, in this class.
 * Have no time to use any (including GoF) pattern,
 * cos today I have to finish this task.
 * Ask cos of Ramil's decision, to make a deadline today at 14:00
*/
public class YandexMailTest extends YandexTests {
  /**
   * 1.Send an email.
   * Sends an email with subject defined as "Subject" by default (see implementation for details).
   * The email is send to the sender *self (origin and destination emails are the same email).
   */
  @Test
  public void userCanSendEmail() {
    elementByText("Написать").click();
    elementByName("to").val(username);

    elementByXPath("//input[contains(@name,'subj')]").val("Subject");
    elementByText("Отправить").click();
    elementWithText("Письмо отправлено");
  }

  /**
   * 2.Delete one newest email with subject defined as "Subject" (see implementation for details),
   * fails if there is no any email with such subject, otherwise deletes one the newest email.
   * - Uncompleted, cos of deletion exactly a last email instead of an any one email on demand.
   * + Completed, cos already fits into technical requirements of a task, so user really can delete an email.
   *
  */
  @Test
  public void userCanDeleteEmail() {
    enterAllCategories();
    SelenideElement mail=showEmailsWithSameSubject();
    mail.click();
    elementByText("Удалить").click();
  }

  /**
   * 3.Check if user can move email.
   * There is an ambiguity what does it exactly mean "move an email",
   * so for this reason this method has two implementations,
   * with moving an email into a folder (actually is commented out)
   * and with drag-and-dropping an email into a different section (actually into the "Отправленные" section).
   * The last version is uncommented for now.
   *
   * P.S>Of course I know about that solution is unclean, and, according to Martin Fowler such code smells bad,
   * but I have no choice to pull these two implementations into a different classes: Just have no enough time,
   * cos of Ramil, who have set a deadline time of the project to the current day 14:00.
  */
  @Test
  public void userCanMoveEmail() {
    enterAllCategories();
    SelenideElement topEmail=showEmailsWithSameSubject();

    /*TODO(V_SUVOROV):Uncomment following code, if you would like to use an implementation with moving email to a folder
        P.S> No time to make a classes for different implementations...
    */
    /*topEmail.click();

    SelenideElement toFolder=elementByXPath("//*[text()='В папку']");
    toFolder.click();
    SelenideElement folderName=elementByXPath("//input[@placeholder='Введите имя папки']");

    folderName.val("Folder").pressEnter();*/

    /*TODO(V_SUVOROV):Comment out following code, if you would like to use an implementation with moving email to a folder
        P.S> No time to make a classes for different implementations...
    */
    topEmail.dragAndDropTo(elementByText("Отправленные"));
  }

  /**
   * 4.Find an email with subject defined as "Subject" (see implementation for details),
   * fails if there is no any email with such subject,
   * otherwise clicks on found email.
  */
  @Test
  public void userCanFindEmail() {
    elementByAttribute("placeholder","Поиск").click();
    elementByAttribute("placeholder","Введите текст из письма, его тему или отправителя")
            .val("Subject")
            .pressEnter();
    //particular case, getTopEmail doesn't work here because of different xpathes of a top email
    final String topEmailXPath =
            "//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[3]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/div/div[2]"
            ;
    SelenideElement topEmail=elementByXPath(topEmailXPath);
    topEmail.click();
  }

  /**
   * 5.Set label "Избранное" to the newest email with subject defined as "Subject" (see implementation for details),
   * fails if there is no any email with such subject,
   * otherwise sets the label.
  */
  @Test
  public void userCanSetLabelForEmail() {
    enterAllCategories();
    SelenideElement mail=showEmailsWithSameSubject();
    mail.click();
    elementByText("Метка").click();
    SelenideElement label=elementByXPath("//input[@placeholder='Введите название метки']");
    label.val("Избранное").pressEnter();
  }

  /**
   * Show emails with subject defined as "Subject":
   * perform all actions to make emails listed.
   *  @returns top email from emails with subject as "Subject"
  */
  SelenideElement showEmailsWithSameSubject(){
    if(doesEmailsWithSameSubjectVisible)return getTopEmail();
    elementByXPath("//span[text()='Subject']").click();
    doesEmailsWithSameSubjectVisible=true;
    return getTopEmail();
  }


  /**
   * Low level method for showEmailsWithSameSubject
   *  @returns top email from emails with subject as "Subject"
   */
  SelenideElement getTopEmail(){
    final String topEmailXPath =
            "//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[3]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/div/div[1]/div/div[2]/div[1]/div[1]"
            ;
    return elementByXPath(topEmailXPath);
  }
  /**
   * Enters into all categories of yandex email account
  */
  void enterAllCategories(){
    elementByXPath("//span[@title='Проверить, есть ли новые письма (F9)']").click();
    elementByText("Входящие").click();
    elementByText("Все категории").click();
  }


  /*
  Very important boolean, you should not remove.
  Explanation: without this var list of emails at an account will be opened and closed
  instead of keeping opened during the testing.
  So userCanSetLabelForEmail wont work correctly together with userCanDeleteEmail.
  If you don't care - yo're free to remove the variable.
  But if you remove it, you will be responsible for all bugs will occur.
  P.S>This is unclean solution, but cos of Ramil I have no time to fix it.
  */
  static boolean doesEmailsWithSameSubjectVisible=false;
}
