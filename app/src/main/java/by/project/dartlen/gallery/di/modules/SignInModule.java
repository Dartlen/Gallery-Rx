package by.project.dartlen.gallery.di.modules;

import by.project.dartlen.gallery.di.application.GoogleSignInOptionsModule;
import dagger.Module;
import dagger.Provides;


@Module(includes = GoogleSignInOptionsModule.class)
@SignInScope
public class SignInModule {

    /*@SignInScope
    @ContributesAndroidInjector
    abstract SignInFragment loginFragment();*/

    /*@Provides
    SignInIteractor provideIteractor(SignInRepository repository){
        return new SignInIteractor(repository);
    }

    @Provides
    SignInRepository provideRepository(){
        return new SignInRepository();
    }*/

}
