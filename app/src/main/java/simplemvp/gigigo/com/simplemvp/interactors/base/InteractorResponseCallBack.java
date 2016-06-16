package simplemvp.gigigo.com.simplemvp.interactors.base;

/**
 * Created by nubor on 08/06/2016.
 */
public interface InteractorResponseCallBack {
    //Object--> will be wrapperobjet InteractorResponse
    void onSucces(Object Result);

    void onFail(Object Result);

    void onError(Object Result);

}
