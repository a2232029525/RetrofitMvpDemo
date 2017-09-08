package www.yckj.com.myapplication.JsonFactory;

import android.app.Application;
import android.widget.Toast;

import rx.Subscriber;
import www.yckj.com.myapplication.callBack.SimpleCallBack;

/**
 * Created by 22320 on 2017/9/6.
 */

public class SimpleSubscriber<T> extends Subscriber<T> {
    private final SimpleCallBack<T> simpleCallBack;
    private final Application application;

    public SimpleSubscriber(SimpleCallBack<T> simpleCallBack, Application application) {
        this.simpleCallBack = simpleCallBack;
        this.application = application;
    }

    @Override
    public void onStart() {
        super.onStart();
        simpleCallBack.onStart();
    }

    @Override
    public void onCompleted() {
        simpleCallBack.onComplete();
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(application, "网络连接失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(T t) {
        simpleCallBack.onNext(t);
    }
}
