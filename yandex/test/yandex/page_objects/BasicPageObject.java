package yandex.page_objects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Base for all page objects.
 *
 * Note:
 * 1)All public methods for all page objects are actions that can be performed on any particular page.
 * 2)On the other hand all non-public methods for all page objects are for internal usage only
 * (for implementation purposes mostly).
 * 3)Return value of any method of any page object is meaningful and means following:
 *  - void - that operation should not continue i.e. the method describes a terminal operation.
 *  - self page object - not only for convinience, but means that operation may be continued,
 * it is not end for interaction with page in opposed to the void return value case.
 *  - other page object - an other page should appear or a most part of the page should be changed
 *  - any other value - may be terminal or non-terminal operation, depending on name,
 *  for non-terminal - means same as for self page object returned value, but returns requested value instead;
 *  is terminal otherwise.
 */
public class BasicPageObject {
    /**
     * All following functions returns an element if found and displayed,
     * otherwise - null is returned.
     */
    public  static SelenideElement elementByXPath(final String xpath){
        return nullOrDisplayed($(byXpath(xpath)));
    }
    public  static SelenideElement elementByText(final String text){
        return nullOrDisplayed($(byText(text)));
    }
    public  static SelenideElement elementWithText(final String text){
        return nullOrDisplayed($(withText(text)));
    }
    public  static SelenideElement elementByName(final String name){
        return nullOrDisplayed($(byName(name)));
    }
    public  static SelenideElement elementByAttribute(final String attributeName, final String attributeValue){
        return nullOrDisplayed($(byAttribute(attributeName,attributeValue)));
    }
    public  static  SelenideElement elementByLinkText(final String linkText){
        return nullOrDisplayed($(byLinkText(linkText)));
    }



    static SelenideElement nullOrDisplayed(SelenideElement foundElement){
        return (foundElement.waitWhile(hidden,TIMEOUT,POLLING_INTERVAL).shouldBe(visible).is(visible))?foundElement:null;
    }
    final static int POLLING_INTERVAL = 100;
    final static int TIMEOUT = 100000;
}
