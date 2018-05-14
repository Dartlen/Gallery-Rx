package by.project.dartlen.gallery.di.application;

import android.support.v4.app.Fragment;

import javax.inject.Singleton;

import by.project.dartlen.gallery.di.gallery.GalleryModule;
import by.project.dartlen.gallery.ui.activity.Activity;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AppModule.class, NavigationModule.class, GalleryModule.class,
        AndroidSupportInjectionModule.class, ActivityBindingModule.class, GoogleSignInOptionsModule.class})

@Singleton
public interface AppComponent {
    void inject(Activity galleryActivity);
    void inject(Fragment galleryFragment);
}
