package by.project.dartlen.gallery.business;

import by.project.dartlen.gallery.repositories.activity.ActivityRepository;

public class ActivityInteractor {

    private ActivityRepository repository;

    public ActivityInteractor(ActivityRepository repository){
        this.repository = repository;
    }
}
