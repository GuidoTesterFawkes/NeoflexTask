package yandex.page_objects;

public class NewMailPage extends BasicPageObject {
    public NewMailPage typeDestination(String destination){
        elementByName("to")
                .val(destination);
        return this;
    }
    public NewMailPage typeSubject(String subject){
        elementByXPath("//input[contains(@name,'subj')]")
                .val(subject);
        return this;
    }
    public MailHaveBeenSentPage send(){
        elementByText("Отправить")
                .click();
        return new MailHaveBeenSentPage();
    }
}
