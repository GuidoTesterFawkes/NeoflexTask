package yandex.page_objects;

import com.codeborne.selenide.SelenideElement;

import static yandex.page_objects.BasicPageObject.elementByXPath;

public class AllEmailsPage {
    public EmailPage clickTopEmail(){
        topEmail()
                .click();
        return new EmailPage();
    }
    public void dragAndDropTopMailTo(SelenideElement element){
        topEmail().dragAndDropTo(element);
    }

    /**
     * For implementation purposes getter
     */
    SelenideElement topEmail(){
        final String topEmailXPath =
                "//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[3]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/div/div[1]/div/div[2]/div[1]/div[1]"
                ;
        return elementByXPath(topEmailXPath);
    }
}
