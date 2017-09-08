package www.yckj.com.myapplication.Api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 22320 on 2017/9/6.
 */

public interface ApiService {
    @GET("microservice/weather")
    Observable<String> requestWeather(@Query("citypinyin") String citypinyin);
}
