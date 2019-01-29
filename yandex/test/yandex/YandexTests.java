package yandex;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static yandex.Utility.elementByLinkText;
import static yandex.Utility.elementByName;

/**
 * Utility class providing me a syntax sugar, for internal usage only
 */
class Utility{

  final static int POLLING_INTERVAL = 100;
  final static int TIMEOUT = 100000;

  static SelenideElement nullOrDisplayed(SelenideElement foundElement){
    return (foundElement.waitWhile(hidden,TIMEOUT,POLLING_INTERVAL).shouldBe(visible).is(visible))?foundElement:null;
  }

  /**
   * All following functions returns an element if found and displayed,
   * otherwise - null is returned.
   */

  public  static SelenideElement elementByXPath(final String xpath){
    return nullOrDisplayed($(byXpath(xpath)));

  }
  public  static  SelenideElement elementByText(final String text){
    return nullOrDisplayed($(byText(text)));
  }
  public  static  SelenideElement elementWithText(final String text){
    return nullOrDisplayed($(withText(text)));
  }
  public  static  SelenideElement elementByName(final String name){
    return nullOrDisplayed($(byName(name)));
  }
  public  static  SelenideElement elementByAttribute(final String attributeName, final String attributeValue){
    return nullOrDisplayed($(byAttribute(attributeName,attributeValue)));
  }
  public  static  SelenideElement elementByLinkText(final String linkText){
    return nullOrDisplayed($(byLinkText(linkText)));
  }

}
/**
 * Base class for all yandex tests
*/
public abstract class YandexTests {
  /*
  login and password that was used during the testing:
  username = "YaMailSvcAutoTestAccount@yandex.ru"
  password = "bypassthepassword"
  */
  protected static String username =  System.getProperty("yandex.username", "enter-your-yandex-username");
  protected static String password =  System.getProperty("yandex.password", "enter-your-yandex-password");

  @Rule
  public ScreenShooter screenShooter = ScreenShooter.failedTests();

  @BeforeClass
  public static void openInbox() {
    timeout = 10000;
    baseUrl = "https://yandex.ru";
    startMaximized = true;
    browser = "chrome";
    addListener(new Highlighter());
    
    open(baseUrl);
    login();
  }


  @AfterClass
  public static void logout() {
    closeWebDriver();
  }

  private static void login() {
    elementByLinkText("Войти в почту").click();
    elementByName("login").val(username).pressEnter();
    elementByName("passwd").val(password).pressEnter();
  }
}
