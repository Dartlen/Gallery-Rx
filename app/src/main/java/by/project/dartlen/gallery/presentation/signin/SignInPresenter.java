package by.project.dartlen.gallery.presentation.signin;

import com.arellomobile.mvp.InjectViewState;

import by.project.dartlen.gallery.presentation.common.BasePresenter;
import ru.terrakok.cicerone.Router;

import static by.project.dartlen.gallery.utils.Constants.GALLERY;
import static by.project.dartlen.gallery.utils.Constants.SIGNUP;

@InjectViewState
public class SignInPresenter extends BasePresenter<SignInView> {

    private Router router;

    public SignInPresenter(Router router){
        this.router = router;
    }

    public void onLogined(){
        router.navigateTo(GALLERY);

    }

    public void onRegistration(){
        router.navigateTo(SIGNUP);
    }

}
