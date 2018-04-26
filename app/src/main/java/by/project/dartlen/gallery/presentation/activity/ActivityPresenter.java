package by.project.dartlen.gallery.presentation.activity;

import com.arellomobile.mvp.InjectViewState;

import by.project.dartlen.gallery.business.ActivityInteractor;
import by.project.dartlen.gallery.presentation.common.BasePresenter;

@InjectViewState
public class ActivityPresenter extends BasePresenter<ActivityView> {

    private ActivityInteractor interactor;

    public ActivityPresenter(ActivityInteractor activityInteractor){
        this.interactor = activityInteractor;
    }

}
