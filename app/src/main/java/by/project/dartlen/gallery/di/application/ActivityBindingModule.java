package by.project.dartlen.gallery.di.application;

import by.project.dartlen.gallery.di.modules.GalleryModule;
import by.project.dartlen.gallery.di.modules.LoginModule;
import by.project.dartlen.gallery.ui.activity.Activity;
import by.project.dartlen.gallery.ui.signin.LoginFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = {GalleryModule.class, LoginModule.class})
    abstract Activity activity();
}
