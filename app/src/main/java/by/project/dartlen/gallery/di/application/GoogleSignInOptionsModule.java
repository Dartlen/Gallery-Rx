package by.project.dartlen.gallery.di.application;

import android.content.Context;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class GoogleSignInOptionsModule {
    private GoogleSignInOptions gso;
    private Context context;

    public GoogleSignInOptionsModule(Context context){
         gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                 .requestIdToken("910834012347-u80ppevu3rsh52lvo0di4ltufldpsqme.apps.googleusercontent.com")
                .requestEmail()
                .build();

         this.context = context;
    }

    @Provides
    @Singleton
    GoogleSignInClient provideGoogleSignInAccount() {
        return GoogleSignIn.getClient(context, gso);
    }

    @Provides
    @Singleton
    FirebaseAuth provideFirebaseAuth(){
        return FirebaseAuth.getInstance();
    }

}
