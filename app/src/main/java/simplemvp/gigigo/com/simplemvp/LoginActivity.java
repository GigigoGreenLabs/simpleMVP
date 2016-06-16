package simplemvp.gigigo.com.simplemvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import simplemvp.gigigo.com.simplemvp.interfaces.LoginView;
import simplemvp.gigigo.com.simplemvp.presenters.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter mLoginPresenter;
    Button btnLogin;
    Button btnRetrieve;
    EditText txtUser;
    EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //withoutdagger
        this.mLoginPresenter = new LoginPresenter(this);
        getViews();
        setListeners();

    }

    private void getViews() {

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRetrieve = (Button) findViewById(R.id.btnRetrievePassword);

        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
    }

    private void setListeners() {

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.doLogin(getUserString(), getPasswordString());
            }
        });
    }

    private String getUserString() {
        return getEditTextString(txtUser);
    }

    private String getPasswordString() {
        return getEditTextString(txtPassword);
    }

    //base, DONDE IRIA ESTA comprobacion?
    private String getEditTextString(EditText txt) {
        if (txt != null)
            return txt.getText().toString();
        else
            return "";
    }

    @Override
    public void loginSuccessFully() {
        Toast.makeText(this, "Login done!", Toast.LENGTH_LONG).show();

    }

    @Override
    public void credentialsValidationError() {
        Toast.makeText(this, "Error credentials valiadtion", Toast.LENGTH_LONG).show();
    }

    @Override
    public void validationInputaDataError() {
        Toast.makeText(this, "Error Validation Input Data ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String str) {
        Log.e("", str);
    }
}
