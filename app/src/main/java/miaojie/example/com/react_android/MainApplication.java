package miaojie.example.com.react_android;

import android.app.Application;
import android.app.DownloadManager;
import android.util.Log;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

/**
 * Created by miaorenjie_sx on 2017/8/30.
 */

public class MainApplication extends Application implements ReactApplication {
    CommnPackage commnPackage=new CommnPackage();
    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Nullable
        @Override
        protected String getJSBundleFile() {
//            Log.e("asd",super.getJSBundleFile()+"sad");
//            return super.getJSBundleFile();
            return "/storage/emulated/0/asd/android.bundle";
        }

        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage(),
                    commnPackage
            );
        }

    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this,false);

    }
}
