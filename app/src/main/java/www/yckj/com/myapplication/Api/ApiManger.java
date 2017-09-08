package www.yckj.com.myapplication.Api;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import www.yckj.com.myapplication.JsonFactory.SimpleSubscriber;
import www.yckj.com.myapplication.MyApp;
import www.yckj.com.myapplication.callBack.SimpleCallBack;

/**
 * Created by 22320 on 2017/9/6.
 */

public class ApiManger {
    private final ApiService apiService;
    private final MyApp myApp;

    public ApiManger() {
        apiService = MyApp.getMyApp().getRetrofit().create(ApiService.class);
        myApp = MyApp.getMyApp();
    }

    public void requestWeather(String cityName, final SimpleCallBack<String> callBack){
        apiService.requestWeather(cityName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SimpleSubscriber<String>(callBack,myApp));
    }
}
