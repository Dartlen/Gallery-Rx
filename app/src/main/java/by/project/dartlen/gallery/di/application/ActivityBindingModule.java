package by.project.dartlen.gallery.di.application;

import by.project.dartlen.gallery.di.modules.GalleryModule;
import by.project.dartlen.gallery.ui.activity.Activity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = {GalleryModule.class})
    abstract Activity activity();
}
