package yandex.page_objects;

import static yandex.page_objects.BasicPageObject.elementByXPath;

public class FoundEmailsPage {
    public void clickOnTopMail(){
        //particular case, getTopEmail doesn't work here because of different xpathes of a top email
        final String topEmailXPath =
                "//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[3]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/div/div[2]"
                ;
        elementByXPath(topEmailXPath)
                .click();
    }
}
