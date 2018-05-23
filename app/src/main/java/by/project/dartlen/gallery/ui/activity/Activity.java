package by.project.dartlen.gallery.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.project.dartlen.gallery.GalleryApp;
import by.project.dartlen.gallery.R;
import by.project.dartlen.gallery.presentation.activity.ActivityPresenter;
import by.project.dartlen.gallery.presentation.activity.ActivityView;
import by.project.dartlen.gallery.ui.gallery.GalleryFragment;
import by.project.dartlen.gallery.ui.signin.SignInFragment;
import by.project.dartlen.gallery.ui.signup.SignUpFragment;
import dagger.Lazy;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

import static by.project.dartlen.gallery.utils.Constants.GALLERY;
import static by.project.dartlen.gallery.utils.Constants.LOGIN;
import static by.project.dartlen.gallery.utils.Constants.SIGNUP;


public class Activity extends MvpAppCompatActivity implements ActivityView {

    @InjectPresenter
    ActivityPresenter presenter;

    @Inject
    NavigatorHolder navigatorHolder;

    @Inject
    Lazy<GalleryFragment> galleryFragmentLazy;
    @Inject
    Lazy<SignInFragment> loginFragmentLazy;
    @Inject
    Lazy<SignUpFragment> signUpFragmentLazy;

    @Inject
    Router router;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @ProvidePresenter
    ActivityPresenter providePresenter(){
        GalleryApp.getComponentsManager().getGalleryComponent().inject(this);
        return new ActivityPresenter(router);
    }

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.main_container) {
        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch(screenKey) {
                case LOGIN:
                    return loginFragmentLazy.get();
                case GALLERY:
                    return galleryFragmentLazy.get();
                case SIGNUP:
                    return signUpFragmentLazy.get();
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
        GalleryApp.getComponentsManager().getGalleryComponent().inject(this);
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        presenter.onStart();
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle app bar item clicks here. The app bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.append:

                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}