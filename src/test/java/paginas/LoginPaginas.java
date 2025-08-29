package LoginPaginas;

import core.Driver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import Mapas.LoginMapas;
import org.openqa.selenium.support.PageFactory;

public class LoginPaginas extends LoginMapas {

    public LoginPaginas() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver()), this);
    }

    public void realizarLogin(String email, String senha) {
        loginbtnpage.click();
        inpEmail.sendKeys(email);
        inpPassword.sendKeys(senha);
        btnLogin.click();
    }

    public String getTxtAndroidPopup() {
        return txtAndroidPopup.getText();
    }

    public String getTxtNotAuthEmail() {
        return txtAuthEmailError.getText();
    }

    public String getTxtNotAuthPassword() {
        return txtAuthPasswordError.getText();
    }

    public void realizarCadastro(String email, String senha) {
        inpEmail.sendKeys(email);
        inpPassword.sendKeys(senha);
        inpConfirmPassword.sendKeys(senha);
    }

    public void clickToSignUp(){
        btnSignUp.click();
    }

    public void clickToConfirmSignUp(){
        btnConfirmSignUp.click();
    }

}
