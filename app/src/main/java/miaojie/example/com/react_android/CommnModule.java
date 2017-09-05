package miaojie.example.com.react_android;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;

/**
 * Created by miaorenjie_sx on 2017/9/4.
 */

public class CommnModule extends ReactContextBaseJavaModule {
    private ReactApplicationContext mContext;
    private final String MOUDLE_NAME="commModule";

    public CommnModule(ReactApplicationContext reactContext) {
        super(reactContext);
        mContext=reactContext;
    }
    @ReactMethod
    public void androidCallRn(String str)
    {
        mContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit("qqq",str);
    }
    @ReactMethod
    public void rnCallNative(String phone) {

        // 跳转到打电话界面
        Log.e("phone",phone);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // 跳转需要添加flag, 否则报错
        mContext.startActivity(intent);
    }
    @ReactMethod
    public void callPromise(String str, final Promise promise)
    {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                    promise.resolve("asd");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    public String getName() {
        return MOUDLE_NAME;
    }
}
