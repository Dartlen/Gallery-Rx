package by.project.dartlen.gallery.presentation.gallery;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.HashMap;

import by.project.dartlen.gallery.model.entities.Image;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface GalleryView extends MvpView{
    void showImages(HashMap<String, Image> list);
}
