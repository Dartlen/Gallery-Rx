package by.project.dartlen.gallery.presentation.gallery;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.HashMap;

import by.project.dartlen.gallery.business.gallery.GalleryInteractor;
import by.project.dartlen.gallery.model.entities.Image;
import by.project.dartlen.gallery.presentation.common.BasePresenter;
import by.project.dartlen.gallery.presentation.common.SchedulersProvider;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class GalleryPresenter extends BasePresenter<GalleryView> {

    private GalleryInteractor galleryInteractor;
    private boolean isAlreadyUpdating;
    private SchedulersProvider schedulersProvider;

    public GalleryPresenter(GalleryInteractor galleryInteractor, SchedulersProvider schedulersProvider){
        this.galleryInteractor = galleryInteractor;
        this.schedulersProvider = schedulersProvider;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getImagesList();
    }

    public void getImagesList(){
        if(isAlreadyUpdating){
            return;
        }

        isAlreadyUpdating = true;
        Disposable disposable = galleryInteractor.getImages().observeOn(schedulersProvider.ui())
                .doAfterTerminate(() -> {
                    isAlreadyUpdating = false;
                })
                .subscribe(images -> {
                    //TODO: вывод результата
                });
        unsubscribeOnDestroy(disposable);
    }

}
