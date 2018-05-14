package by.project.dartlen.gallery.presentation.gallery;

import com.arellomobile.mvp.InjectViewState;

import by.project.dartlen.gallery.business.gallery.GalleryInteractor;
import by.project.dartlen.gallery.presentation.common.BasePresenter;

@InjectViewState
public class GalleryPresenter extends BasePresenter<GalleryView> {

    private GalleryInteractor galleryInteractor;

    public GalleryPresenter(GalleryInteractor galleryInteractor){
        this.galleryInteractor = galleryInteractor;
    }
}
