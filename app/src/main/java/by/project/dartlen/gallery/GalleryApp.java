package by.project.dartlen.gallery;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import by.project.dartlen.gallery.di.ComponentsManager;

public class GalleryApp extends Application{

    private static ComponentsManager componentsManager;
    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponentsTree();
        initAppComponent();
        initLeakCanary();

    }

    public static ComponentsManager getComponentsManager(){
        return componentsManager;
    }

    public static RefWatcher getRefWatcher(Context context){
        GalleryApp application = (GalleryApp) context.getApplicationContext();
        return application.refWatcher;
    }

    private void initLeakCanary(){
        if(LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        refWatcher = LeakCanary.install(this);
    }

    private void initAppComponent(){
        componentsManager.getAppComponent();
    }

    private void initComponentsTree(){
        componentsManager = new ComponentsManager(this);
    }

}
