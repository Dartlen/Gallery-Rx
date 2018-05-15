package by.project.dartlen.gallery.di.gallery;

import by.project.dartlen.gallery.business.gallery.GalleryInteractor;
import by.project.dartlen.gallery.repositories.gallery.GalleryRepository;
import dagger.Module;
import dagger.Provides;

@Module
@GalleryScope
public class GalleryModule {

    @Provides
    @GalleryScope
    GalleryInteractor provideInteractor(GalleryRepository repository){
        return new GalleryInteractor(repository);
    }

    @Provides
    @GalleryScope
    GalleryRepository provideRepository(){
        return new GalleryRepository();
    }

}
