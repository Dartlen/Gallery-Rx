package by.project.dartlen.gallery.di.gallery;

import by.project.dartlen.gallery.business.gallery.GalleryInteractor;
import by.project.dartlen.gallery.di.scope.FragmentScope;
import by.project.dartlen.gallery.repositories.gallery.GalleryRepository;
import by.project.dartlen.gallery.ui.gallery.GalleryFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
@GalleryScope
public abstract class GalleryModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract GalleryFragment galleryFragment();

    /*@Provides
    @GalleryScope
    GalleryInteractor provideInteractor(GalleryRepository repository){
        return new GalleryInteractor(repository);
    }

    @Provides
    @GalleryScope
    GalleryRepository provideRepository(){
        return new GalleryRepository();
    }*/

}
