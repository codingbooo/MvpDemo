package codingbo.mvpdemo;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by bob
 * on 17.2.9.
 */

public class DLApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}
