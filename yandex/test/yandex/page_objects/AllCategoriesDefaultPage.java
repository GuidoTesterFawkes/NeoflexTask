package yandex.page_objects;

public class AllCategoriesDefaultPage extends BasicPageObject {
    public NewMailPage writeAnEmail(){
        elementByText("Написать")
                .click();
        return new NewMailPage();
    }
    public AllEmailsPage clickMailsWithSameSubject(String subject){
        elementByXPath("//span[text()='"+subject+"']")
                .click();
        return new AllEmailsPage();
    }
    public FoundEmailsPage findAnEmail(String subject){
        elementByAttribute("placeholder","Поиск")
                .click();
        elementByAttribute("placeholder","Введите текст из письма, его тему или отправителя")
                .val(subject)
                .pressEnter();
        return new FoundEmailsPage();
    }
}
