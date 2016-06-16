package simplemvp.gigigo.com.simplemvp.presenters;

import android.text.TextUtils;

import simplemvp.gigigo.com.simplemvp.interactors.base.InteractorResponseCallBack;
import simplemvp.gigigo.com.simplemvp.interactors.login.LoginInteractor;
import simplemvp.gigigo.com.simplemvp.interactors.login.RetrievePasswordInteractor;
import simplemvp.gigigo.com.simplemvp.interfaces.LoginView;
import simplemvp.gigigo.com.simplemvp.interfaces.base.IView;
import simplemvp.gigigo.com.simplemvp.model.login.ValidUserModel;

/**
 * Created by nubor on 08/06/2016.
 */
public class LoginPresenter {
    private LoginView mLoginView;
    private LoginInteractor mLoginInteractor;
    private RetrievePasswordInteractor mRetrievePasswordInteractor;


    //region with base items
    public LoginPresenter(IView view) {

    }

    //endregion
//region with dagger
    public LoginPresenter(LoginView loginview, LoginInteractor loginInteractor,
                          RetrievePasswordInteractor retrievePasswordInteractor) {

    }

    //endregion


    public LoginPresenter(LoginView loginview) {
        this.mLoginView = loginview;
        this.mLoginInteractor = new LoginInteractor();
        this.mRetrievePasswordInteractor = new RetrievePasswordInteractor();
    }


    public void doLogin(String user, String pass) {
        //DONDE IRIA EL TRIM?
        if (TextUtils.isEmpty(user.trim()) || TextUtils.isEmpty(pass.trim())) {
            mLoginView.validationInputaDataError();
        } else {
            mLoginInteractor.setmUser(user);
            mLoginInteractor.setmPassword(pass);
            mLoginInteractor.setValidUserModel( new ValidUserModel());// si hubiese mas fuentes de datos tendrimaosun provider q nos daria
            mLoginInteractor.call(new InteractorResponseCallBack() {
                @Override
                public void onSucces(Object Result) {
                    mLoginView.loginSuccessFully();
                }

                @Override
                public void onFail(Object Result) {
                    mLoginView.credentialsValidationError();
                }

                @Override
                public void onError(Object result) {
                    mLoginView.onError(result.toString());
                }
            });
        }

    }
}
