package by.project.dartlen.gallery.repositories.gallery;

import by.project.dartlen.gallery.model.db.ImageDao;
import by.project.dartlen.gallery.model.mappers.GalleryMapper;

public class GalleryRepository {

    private GalleryMapper galleryMapper;
    private ImageDao imageDao;
    public GalleryRepository(GalleryMapper galleryMapper, ImageDao imageDao){
        this.galleryMapper = galleryMapper;
        this.imageDao = imageDao;
    }
}
