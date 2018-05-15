package by.project.dartlen.gallery.di;

import android.content.Context;

import by.project.dartlen.gallery.di.application.AppComponent;
import by.project.dartlen.gallery.di.application.AppModule;
import by.project.dartlen.gallery.di.application.DaggerAppComponent;
import by.project.dartlen.gallery.di.application.GoogleSignInOptionsModule;
import by.project.dartlen.gallery.di.application.RoomModule;
import by.project.dartlen.gallery.di.gallery.GalleryComponent;
import by.project.dartlen.gallery.di.gallery.GalleryModule;

public class ComponentsManager {
    private Context context;

    private AppComponent appComponent;
    private GalleryComponent galleryComponent;

    public ComponentsManager(Context context){
        this.context = context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        if(appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(context))
                    .googleSignInOptionsModule(new GoogleSignInOptionsModule(context))
                    .roomModule(new RoomModule(context))
                    .build();
        }
        return appComponent;
    }

    public GalleryComponent getGalleryComponent(){
        if(galleryComponent == null){
            galleryComponent = appComponent.plusGalleryComponent(new GalleryModule());
        }
        return galleryComponent;
    }

    public void clearGalleryComponent(){
        galleryComponent = null;
    }

}
