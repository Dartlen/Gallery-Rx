package by.project.dartlen.gallery.di.gallery;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;

import org.mapstruct.factory.Mappers;

import by.project.dartlen.gallery.business.gallery.GalleryInteractor;
import by.project.dartlen.gallery.data.permission.PermissionsRepository;
import by.project.dartlen.gallery.model.db.ImageDao;
import by.project.dartlen.gallery.model.mappers.GalleryMapper;
import by.project.dartlen.gallery.presentation.common.SchedulersProvider;
import by.project.dartlen.gallery.repositories.gallery.GalleryRepository;
import dagger.Module;
import dagger.Provides;

@Module
@GalleryScope
public class GalleryModule {

    @Provides
    @GalleryScope
    GalleryInteractor provideInteractor(GalleryRepository repository, PermissionsRepository permissionsRepository,
                                        SchedulersProvider schedulersProvider){
        return new GalleryInteractor(repository, permissionsRepository, schedulersProvider);
    }

    @Provides
    @GalleryScope
    GalleryRepository provideRepository(GalleryMapper galleryMapper, ImageDao imageDao, DatabaseReference databaseReference,
                                        StorageReference storageReference){
        return new GalleryRepository(galleryMapper, imageDao, databaseReference, storageReference);
    }

    @Provides
    @GalleryScope
    GalleryMapper provideMapper(){
        return Mappers.getMapper(GalleryMapper.class);
    }


}
