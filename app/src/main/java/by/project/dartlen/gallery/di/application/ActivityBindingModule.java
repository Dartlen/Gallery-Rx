package by.project.dartlen.gallery.di.application;

import by.project.dartlen.gallery.di.gallery.GalleryModule;
import by.project.dartlen.gallery.di.modules.SignInModule;
import by.project.dartlen.gallery.di.signup.SignUpModule;
import by.project.dartlen.gallery.ui.activity.Activity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = {GalleryModule.class, SignInModule.class, SignUpModule.class})
    abstract Activity activity();
}
