package by.project.dartlen.gallery.presentation.signin;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import by.project.dartlen.gallery.presentation.common.BasePresenter;
import ru.terrakok.cicerone.Router;

import static by.project.dartlen.gallery.utils.Constants.GALLERY;

@InjectViewState
public class SignInPresenter extends BasePresenter<SignInView> {

    private Router router;

    public SignInPresenter(Router router){
        this.router = router;
    }

    public void onLogined(){
        router.navigateTo(GALLERY);
    }

}
