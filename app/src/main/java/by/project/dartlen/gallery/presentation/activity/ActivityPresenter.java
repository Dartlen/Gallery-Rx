package by.project.dartlen.gallery.presentation.activity;

import com.arellomobile.mvp.InjectViewState;

import by.project.dartlen.gallery.presentation.common.BasePresenter;
import ru.terrakok.cicerone.Router;

import static com.google.firebase.analytics.FirebaseAnalytics.Event.LOGIN;

@InjectViewState
public class ActivityPresenter extends BasePresenter<ActivityView> {

    private Router router;

    public ActivityPresenter(Router router){
        this.router = router;
    }

    public void onStart(){
        router.navigateTo(LOGIN);
    }

}
