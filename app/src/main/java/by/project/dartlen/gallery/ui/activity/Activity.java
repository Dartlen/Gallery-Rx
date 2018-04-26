package by.project.dartlen.gallery.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import javax.inject.Inject;

import by.project.dartlen.gallery.GalleryApp;
import by.project.dartlen.gallery.R;
import by.project.dartlen.gallery.business.ActivityInteractor;
import by.project.dartlen.gallery.presentation.activity.ActivityPresenter;
import by.project.dartlen.gallery.presentation.activity.ActivityView;
import by.project.dartlen.gallery.ui.gallery.GalleryFragment;
import dagger.Lazy;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class Activity extends MvpAppCompatActivity implements ActivityView {

    @InjectPresenter
    ActivityPresenter presenter;
    @Inject
    ActivityInteractor activityInteractor;
    @Inject
    NavigatorHolder navigatorHolder;
    @Inject
    Lazy<GalleryFragment> galleryFragmentLazy;

    @ProvidePresenter
    ActivityPresenter providePresenter(){
        GalleryApp.getComponentsManager().getAppComponent().inject(this);
        return new ActivityPresenter(activityInteractor);
    }

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.main_container) {
        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch(screenKey) {
                case "":
                    return null;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
    }
}
