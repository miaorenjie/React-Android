package miaojie.example.com.react_android;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by miaorenjie_sx on 2017/9/4.
 */

public class CommnPackage implements ReactPackage {
    public CommnModule commnModule;
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule>list=new ArrayList<>();
        commnModule=new CommnModule(reactContext);
        list.add(commnModule);
        return list;
    }



    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}
