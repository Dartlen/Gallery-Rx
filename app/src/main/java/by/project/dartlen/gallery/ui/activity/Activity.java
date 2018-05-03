package by.project.dartlen.gallery.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;

import javax.inject.Inject;

import by.project.dartlen.gallery.GalleryApp;
import by.project.dartlen.gallery.R;
import by.project.dartlen.gallery.business.ActivityInteractor;
import by.project.dartlen.gallery.presentation.activity.ActivityPresenter;
import by.project.dartlen.gallery.presentation.activity.ActivityView;
import by.project.dartlen.gallery.ui.gallery.GalleryFragment;
import by.project.dartlen.gallery.ui.signin.LoginFragment;
import dagger.Lazy;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

import static by.project.dartlen.gallery.utils.Constants.GALLERY;
import static by.project.dartlen.gallery.utils.Constants.LOGIN;


public class Activity extends MvpAppCompatActivity implements ActivityView {

    @InjectPresenter
    ActivityPresenter presenter;
    @Inject
    ActivityInteractor activityInteractor;
    @Inject
    NavigatorHolder navigatorHolder;
    @Inject
    Lazy<GalleryFragment> galleryFragmentLazy;
    @Inject
    Lazy<LoginFragment> loginFragmentLazy;
    @Inject
    Router router;
    @Inject
    GoogleSignInClient googleSignInClient;

    @ProvidePresenter
    ActivityPresenter providePresenter(){
        GalleryApp.getComponentsManager().getAppComponent().inject(this);
        return new ActivityPresenter(activityInteractor, router);
    }

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.main_container) {
        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch(screenKey) {
                case LOGIN:
                    return loginFragmentLazy.get();
                case GALLERY:
                    return galleryFragmentLazy.get();
                default:
                    throw new RuntimeException("Unknown screen key!");
            }
        }

        @Override
        protected void showSystemMessage(String message) {
            Toast.makeText(Activity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void exit() {
            finish();
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        presenter.onStart();
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }
}
