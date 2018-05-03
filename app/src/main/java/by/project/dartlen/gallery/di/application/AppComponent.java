package by.project.dartlen.gallery.di.application;

import javax.inject.Singleton;

import by.project.dartlen.gallery.business.ActivityInteractor;
import by.project.dartlen.gallery.di.modules.GalleryModule;
import by.project.dartlen.gallery.ui.activity.Activity;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AppModule.class, NavigationModule.class, GalleryModule.class,
        AndroidSupportInjectionModule.class, ActivityBindingModule.class, GoogleSignInOptionsModule.class})
@Singleton
public interface AppComponent {
    //GalleryComponent plusGalleryComponent(GalleryModule module);
    void inject(Activity galleryActivity);

}
