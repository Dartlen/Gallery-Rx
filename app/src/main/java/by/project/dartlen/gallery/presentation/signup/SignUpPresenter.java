package by.project.dartlen.gallery.presentation.signup;

import com.arellomobile.mvp.InjectViewState;

import by.project.dartlen.gallery.presentation.common.BasePresenter;
import ru.terrakok.cicerone.Router;

import static by.project.dartlen.gallery.utils.Constants.LOGIN;

@InjectViewState
public class SignUpPresenter extends BasePresenter<SignUpView> {
    private Router router;
    public SignUpPresenter(Router router){
        this.router = router;
    }

    public void onRegistered(){
        router.navigateTo(LOGIN);
    }
}
