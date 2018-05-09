package by.project.dartlen.gallery.di.gallery;

import by.project.dartlen.gallery.di.scope.FragmentScope;
import by.project.dartlen.gallery.ui.gallery.GalleryFragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class GalleryModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract GalleryFragment galleryFragment();


}
