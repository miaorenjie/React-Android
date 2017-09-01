package miaojie.example.com.react_android;

import android.content.ComponentName;

import com.facebook.react.ReactActivity;

import javax.annotation.Nullable;

/**
 * Created by miaorenjie_sx on 2017/8/30.
 */

public class MyReactActivity extends ReactActivity {
    @Nullable
    @Override
    protected String getMainComponentName() {
        return "ReactDemo";
    }
}
