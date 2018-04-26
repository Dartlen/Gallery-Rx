package by.project.dartlen.gallery.ui.gallery;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import javax.inject.Inject;

import by.project.dartlen.gallery.GalleryApp;
import by.project.dartlen.gallery.presentation.gallery.GalleryPresenter;
import by.project.dartlen.gallery.presentation.gallery.GalleryView;

public class GalleryFragment extends MvpAppCompatFragment implements GalleryView{

    @InjectPresenter
    GalleryPresenter presenter;

    @Inject
    public GalleryFragment(){

    }



}
