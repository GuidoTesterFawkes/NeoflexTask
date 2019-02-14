package yandex.page_objects;

import static yandex.page_objects.BasicPageObject.elementWithText;

public class MailHaveBeenSentPage {
    public void waitForMailHaveBeenSentMessage(){
        elementWithText("Письмо отправлено");
    }
}
