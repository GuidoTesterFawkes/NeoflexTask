package yandex.page_objects;

public class AuthorizationPage extends BasicPageObject {
    public AllCategoriesDefaultPage loginAccount(String login, String password){
        elementByLinkText("Войти в почту")
                .click();
        elementByName("login")
                .val(login)
                .pressEnter();
        elementByName("passwd")
                .val(password)
                .pressEnter();
        return new AllCategoriesDefaultPage();
    }
}
