package by.project.dartlen.gallery.di.gallery;

import by.project.dartlen.gallery.ui.activity.Activity;
import by.project.dartlen.gallery.ui.gallery.GalleryFragment;
import by.project.dartlen.gallery.ui.signin.SignInFragment;
import by.project.dartlen.gallery.ui.signup.SignUpFragment;
import dagger.Subcomponent;

@Subcomponent(modules = {GalleryModule.class, SignInModule.class, SignUpModule.class})
@GalleryScope
public interface GalleryComponent {
    void inject(Activity galleryActivity);
    void inject(GalleryFragment galleryFragment);
    void inject(SignInFragment signInFragment);
    void inject(SignUpFragment signUpFragment);
}
