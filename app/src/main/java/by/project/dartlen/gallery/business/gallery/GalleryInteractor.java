package by.project.dartlen.gallery.business.gallery;

import java.util.HashMap;

import by.project.dartlen.gallery.data.permission.PermissionsRepository;
import by.project.dartlen.gallery.model.entities.Image;
import by.project.dartlen.gallery.presentation.common.SchedulersProvider;
import by.project.dartlen.gallery.repositories.gallery.GalleryRepository;
import io.reactivex.Single;

public class GalleryInteractor {

    private GalleryRepository repository;
    private PermissionsRepository permissionsRepository;
    private SchedulersProvider schedulersProvider;

    public GalleryInteractor(GalleryRepository repository, PermissionsRepository permissionsRepository,
                             SchedulersProvider schedulersProvider){
        this.repository = repository;
        this.permissionsRepository = permissionsRepository;
        this.schedulersProvider = schedulersProvider;
    }

    public Single<HashMap<String, Image>> getImages(){
        return repository.getImages()
                .subscribeOn(schedulersProvider.io());
    }
}
