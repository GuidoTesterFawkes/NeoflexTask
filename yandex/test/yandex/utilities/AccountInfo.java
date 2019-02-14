package yandex.utilities;

/**
 * Something kinda Singleton & Strategy
 * Required to provide different implementations of login & password getters,
 * for a mock case (internal usage only) and file reading case (used by default)
*/
public abstract class AccountInfo{
    abstract public String login();
    abstract public String password();

    private static AccountInfo _accountInfo = null;

    /**
     * Checks for an AccountInfo instance to return
     * @returns found AccountInfo instance or a newly created one
    */
    public static AccountInfo instance(){
        return (_accountInfo==null)?(_accountInfo=new AccountInfoMock()):_accountInfo;
    }
}

/**
 * For internal usage and debug only.
*/
class AccountInfoMock extends AccountInfo{
    @Override
    public String login() {
        return "YaMailSvcAutoTestAccount@yandex.ru";
    }
    @Override
    public String password() {
        return "bypassthepassword";
    }
}

/**
 * For the most cases, a default AccountInfo implementation
*/
class PropsAccountInfo extends AccountInfo{
    @Override
    public String login() {
        return System.getProperty("yandex.username", "enter-your-yandex-username");
    }

    @Override
    public String password() {
        return System.getProperty("yandex.password", "enter-your-yandex-password");
    }
}

