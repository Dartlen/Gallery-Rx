package by.project.dartlen.gallery.di;

import android.content.Context;

import by.project.dartlen.gallery.di.application.AppComponent;
import by.project.dartlen.gallery.di.application.AppModule;
import by.project.dartlen.gallery.di.application.DaggerAppComponent;
import by.project.dartlen.gallery.di.application.GoogleSignInOptionsModule;

public class ComponentsManager {
    private Context context;

    private AppComponent appComponent;

    public ComponentsManager(Context context){
        this.context = context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        if(appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(context))
                    .googleSignInOptionsModule(new GoogleSignInOptionsModule(context))
                    .build();
        }
        return appComponent;
    }

}
