package simplemvp.gigigo.com.simplemvp.interfaces;

import simplemvp.gigigo.com.simplemvp.interfaces.base.IView;

/**
 * Created by nubor on 08/06/2016.
 */
public interface LoginView extends IView {

    void loginSuccessFully();

    void credentialsValidationError();

    void validationInputaDataError();

    void onError(String str);


}
