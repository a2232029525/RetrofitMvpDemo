package www.yckj.com.myapplication.presenter;

import www.yckj.com.myapplication.Api.ApiManger;
import www.yckj.com.myapplication.callBack.SimpleCallBack;
import www.yckj.com.myapplication.view.WeatherView;

/**
 * Created by 22320 on 2017/9/6.
 */

public class WeatherImp implements WeatherPresenter {
    private final WeatherView weatherView;
    private final ApiManger apiManger;

    public WeatherImp(WeatherView weatherView) {
        this.weatherView = weatherView;
        apiManger = new ApiManger();
    }

    @Override
    public void requestWeatherData(String cityName) {
        apiManger.requestWeather(cityName, new SimpleCallBack<String>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onNext(String s) {
                weatherView.setData(s);
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
