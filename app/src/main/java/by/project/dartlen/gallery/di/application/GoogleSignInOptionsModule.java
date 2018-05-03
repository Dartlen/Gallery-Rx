package by.project.dartlen.gallery.di.application;

import android.content.Context;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class GoogleSignInOptionsModule {
    private GoogleSignInOptions gso;
    private Context context;

    public GoogleSignInOptionsModule(Context context){
         gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
         this.context = context;
    }

    @Provides
    @Singleton
    GoogleSignInClient provideGoogleSignInAccount() {
        return GoogleSignIn.getClient(context, gso);
    }
}
