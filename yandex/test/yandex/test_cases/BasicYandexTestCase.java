package yandex.test_cases;

import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import yandex.page_objects.AllCategoriesDefaultPage;
import yandex.page_objects.AuthorizationPage;
import yandex.utilities.AccountInfo;
import yandex.utilities.Highlighter;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;


/*NOTE(V_SUVOROV): this is a russian task text
1. Отправка письма с заполненным полем «Тема»
2. Удаление письма
3. Перемещение письма из раздела в раздел
4. Поиск письма
5. Пометить письмо как «избранное»
*/



/**
 * Base class for all yandex tests.
 * All derivatives are sequences of invokes of page objects methods,
 * typically starting with loginAccount invoke, returning initial page.
 */
public class BasicYandexTestCase {
  static protected String getLogin(){
    return AccountInfo.instance().login();
  }
  static protected String getPassword(){
    return  AccountInfo.instance().password();
  }
  static protected AllCategoriesDefaultPage loginAccount(){
    return new AuthorizationPage().loginAccount(getLogin(),getPassword());
  }

  @Rule
  public ScreenShooter screenShooter = ScreenShooter.failedTests();

  @BeforeClass
  public static void openBrowser() {
    timeout = 10000;
    baseUrl = "https://yandex.ru";
    startMaximized = true;
    browser = "chrome";
    addListener(new Highlighter());
    
    open(baseUrl);
  }

  @AfterClass
  public static void closeBrowser() {
    closeWebDriver();
  }

}
