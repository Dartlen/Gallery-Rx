package by.project.dartlen.gallery.presentation.activity;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import by.project.dartlen.gallery.business.ActivityInteractor;
import by.project.dartlen.gallery.presentation.common.BasePresenter;
import ru.terrakok.cicerone.Router;

import static com.google.firebase.analytics.FirebaseAnalytics.Event.LOGIN;

@InjectViewState
public class ActivityPresenter extends BasePresenter<ActivityView> {

    private ActivityInteractor interactor;
    private Router router;

    public ActivityPresenter(ActivityInteractor activityInteractor, Router router){
        this.interactor = activityInteractor;
        this.router = router;
    }

    public void onStart(){
        router.navigateTo(LOGIN);
    }

}
