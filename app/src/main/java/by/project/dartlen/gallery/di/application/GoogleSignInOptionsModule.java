package by.project.dartlen.gallery.di.application;

import android.content.Context;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Singleton;

import by.project.dartlen.gallery.R;
import dagger.Module;
import dagger.Provides;

import static android.provider.Settings.Global.getString;

@Module
public class GoogleSignInOptionsModule {
    private GoogleSignInOptions gso;
    private Context context;

    public GoogleSignInOptionsModule(Context context){
         gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                 .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

         this.context = context;
    }

    @Provides
    @Singleton
    GoogleSignInClient provideGoogleSignInAccount() {
        return GoogleSignIn.getClient(context, gso);
    }

    /*@Provides
    @Singleton
    FirebaseAuth provideFirebaseAuth(){
        return FirebaseAuth.getInstance();
    }*/
}
