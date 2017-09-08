package www.yckj.com.myapplication.callBack;

/**
 * Created by 22320 on 2017/9/6.
 */

public interface SimpleCallBack<T> {
    void onStart();
    void onNext(T t);
    void onComplete();
}
