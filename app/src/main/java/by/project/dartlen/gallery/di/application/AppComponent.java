package by.project.dartlen.gallery.di.application;

import javax.inject.Singleton;

import by.project.dartlen.gallery.di.gallery.GalleryComponent;
import by.project.dartlen.gallery.di.gallery.GalleryModule;

import dagger.Component;


@Component(modules = {AppModule.class, NavigationModule.class, GoogleSignInOptionsModule.class, RoomModule.class})
@Singleton
public interface AppComponent {

    GalleryComponent plusGalleryComponent(GalleryModule module);

}
