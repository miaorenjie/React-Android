package miaojie.example.com.react_android;

import android.content.Intent;
import android.net.Uri;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

/**
 * Created by miaorenjie_sx on 2017/9/4.
 */

public class CommnModule extends ReactContextBaseJavaModule {
    private ReactApplicationContext mContext;
    private final String MOUDLE_NAME="CommnMoudle";

    public CommnModule(ReactApplicationContext reactContext) {
        super(reactContext);
        mContext=reactContext;
    }

    public void rnCallNative(String phone) {

        // 跳转到打电话界面
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // 跳转需要添加flag, 否则报错
        mContext.startActivity(intent);
    }

    @Override
    public String getName() {
        return MOUDLE_NAME;
    }
}
