package by.project.dartlen.gallery.business.gallery;

import by.project.dartlen.gallery.repositories.gallery.GalleryRepository;

public class GalleryInteractor {

    private GalleryRepository repository;

    public GalleryInteractor(GalleryRepository repository){
        this.repository = repository;
    }
}
