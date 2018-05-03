package by.project.dartlen.gallery.di.modules;

import by.project.dartlen.gallery.di.scope.FragmentScope;
import by.project.dartlen.gallery.ui.signin.LoginFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LoginModule {
    @FragmentScope
    @ContributesAndroidInjector
    abstract LoginFragment loginFragment();
}
