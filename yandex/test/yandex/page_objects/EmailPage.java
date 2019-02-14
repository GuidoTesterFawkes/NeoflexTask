package yandex.page_objects;

import static yandex.page_objects.BasicPageObject.elementByText;
import static yandex.page_objects.BasicPageObject.elementByXPath;

public class EmailPage {
    public void delete(){
        elementByText("Удалить")
                .click();
    }
    public void toFolder(String foldername){
        elementByXPath("//*[text()='В папку']")
                .click();
        elementByXPath("//input[@placeholder='Введите имя папки']")
                .val(foldername)
                .pressEnter();
    }
    public void setLabel(String label){
        elementByText("Метка")
                .click();
        elementByXPath("//input[@placeholder='Введите название метки']")
                .val(label)
                .pressEnter();
    }
}
