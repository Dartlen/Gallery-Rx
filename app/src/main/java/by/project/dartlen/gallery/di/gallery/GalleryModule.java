package by.project.dartlen.gallery.di.gallery;

import org.mapstruct.factory.Mappers;

import by.project.dartlen.gallery.business.gallery.GalleryInteractor;
import by.project.dartlen.gallery.model.db.ImageDao;
import by.project.dartlen.gallery.model.mappers.GalleryMapper;
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
    GalleryRepository provideRepository(GalleryMapper galleryMapper, ImageDao imageDao){
        return new GalleryRepository(galleryMapper, imageDao);
    }

    @Provides
    @GalleryScope
    GalleryMapper provideMapper(){
        return Mappers.getMapper(GalleryMapper.class);
    }


}
