package simplemvp.gigigo.com.simplemvp.interactors.login;

import android.os.AsyncTask;

import simplemvp.gigigo.com.simplemvp.interactors.base.IInteractor;
import simplemvp.gigigo.com.simplemvp.interactors.base.InteractorResponseCallBack;
import simplemvp.gigigo.com.simplemvp.model.login.ValidUserModel;

/**
 * Created by nubor on 08/06/2016.
 */
public class LoginInteractor implements IInteractor {
    @Override
    public void call(final InteractorResponseCallBack callBack) {
        try {
            if (mValidUserModel != null &&
                    mValidUserModel.User.equals(mUser) &&
                    mValidUserModel.Password.equals(mPassword))
                callBack.onSucces(null);
            else
                callBack.onFail(null);
        } catch (Throwable tr) {
            callBack.onError(tr);
        }

    }

    //
    private String mUser, mPassword;

    public void setmUser(String mUser) {
        this.mUser = mUser;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public void setValidUserModel(ValidUserModel mValidUserModel) {
        this.mValidUserModel = mValidUserModel;
    }

    private ValidUserModel mValidUserModel;

}
