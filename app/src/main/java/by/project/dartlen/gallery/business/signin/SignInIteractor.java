package by.project.dartlen.gallery.business.signin;

import by.project.dartlen.gallery.repositories.signin.SignInRepository;

public class SignInIteractor {

    private SignInRepository signInRepository;

    public SignInIteractor(SignInRepository repository){
        this.signInRepository = repository;
    }
}
