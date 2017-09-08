package www.yckj.com.myapplication;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import www.yckj.com.myapplication.Api.AppInterface;
import www.yckj.com.myapplication.JsonFactory.JsonConverterFactory;

/**
 * Created by 22320 on 2017/9/6.
 */

public class MyApp extends Application{


    private static MyApp myApp;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
    }

    public static MyApp getMyApp() {
        return myApp;
    }

    private Retrofit initRetrofit(){
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(AppInterface.LIST_URL)
                .addConverterFactory(JsonConverterFactory.create()) //添加Gson转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()); // 添加Rxjava适配器
        return builder.build();
    }
    public Retrofit getRetrofit(){

        return initRetrofit();
    }
}
