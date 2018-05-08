package by.project.dartlen.gallery.ui.signin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import by.project.dartlen.gallery.R;
import by.project.dartlen.gallery.business.signin.SignInIteractor;
import by.project.dartlen.gallery.presentation.signin.SignInPresenter;
import by.project.dartlen.gallery.presentation.signin.SignInView;
import by.project.dartlen.gallery.repositories.signin.SignInRepository;
import ru.terrakok.cicerone.Router;

import static by.project.dartlen.gallery.utils.Constants.RC_SIGN_IN;

public class SignInFragment extends MvpAppCompatFragment implements SignInView {

    @InjectPresenter
    SignInPresenter presenter;

    @Inject
    SignInIteractor signInIteractor;

    @Inject
    SignInRepository signInRepository;

    @Inject
    GoogleSignInClient googleSignInClient;

    @Inject
    Router router;

    @Inject
    public SignInFragment(){

    }

    @BindView(R.id.login_google)
    SignInButton signInButton;

    private Unbinder unbinder;

    @ProvidePresenter
    SignInPresenter providePresenter(){
        return new SignInPresenter(router);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, v);
        signInButton.setOnClickListener(v1 -> {
            Intent signInIntent = googleSignInClient.getSignInIntent();
            startActivityForResult(signInIntent, RC_SIGN_IN);
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
                FirebaseAuth.getInstance().signInWithCredential(credential)
                        .addOnCompleteListener(Objects.requireNonNull(getActivity()), task1 -> {
                            Log.d("ok", task1.getResult().getUser().getEmail());
                            presenter.onLogined();
                        });
            }catch (Exception e){
                Toast.makeText(getContext(), "Google sign in failed", Toast.LENGTH_LONG).show();
            }


            //FirebaseApp.initializeApp(getContext());

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
