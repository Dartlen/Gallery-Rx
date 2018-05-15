package by.project.dartlen.gallery.ui.signup;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import by.project.dartlen.gallery.R;
import by.project.dartlen.gallery.presentation.signup.SignUpPresenter;
import by.project.dartlen.gallery.presentation.signup.SignUpView;
import ru.terrakok.cicerone.Router;

public class SignUpFragment extends MvpAppCompatFragment implements SignUpView {
    @InjectPresenter
    SignUpPresenter presenter;

    @Inject
    Router router;

    @Inject
    FirebaseAuth firebaseAuth;

    @Inject
    public SignUpFragment(){

    }

    @BindView(R.id.edite_login)
    EditText editTextLogin;

    @BindView(R.id.edite_password)
    EditText editTextPassword;

    @BindView(R.id.register)
    Button buttonRegister;

    private Unbinder unbinder;

    @ProvidePresenter
    SignUpPresenter providePresenter(){
        return new SignUpPresenter(router);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_signup, container, false);
        unbinder = ButterKnife.bind(this, v);

        buttonRegister.setOnClickListener(v1 -> {
            firebaseAuth.createUserWithEmailAndPassword(editTextLogin.getText().toString(),
                    editTextPassword.getText().toString())
                    .addOnCompleteListener(Objects.requireNonNull(getActivity()), task -> {
                        if(task.isSuccessful()){
                            presenter.onRegistered();
                            Toast.makeText(getContext(), task.getResult().getAdditionalUserInfo().toString(), Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(getContext(), Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_LONG).show();
                        }
                        hideKeyboard();
                    });
        });

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public void hideKeyboard(){
        if(getActivity()!=null)
            if (getActivity().getCurrentFocus() != null) {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                if(imm!=null)
                    imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
            }

    }
}
