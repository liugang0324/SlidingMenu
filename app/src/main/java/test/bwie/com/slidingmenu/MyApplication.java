package test.bwie.com.slidingmenu;

import android.app.Application;

import org.xutils.x;

/**
 * @ Description:
 * @ Date:2017/4/15
 * @ Author:刘刚
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}
