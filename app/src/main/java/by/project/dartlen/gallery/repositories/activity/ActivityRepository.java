package by.project.dartlen.gallery.repositories.activity;

import android.content.SharedPreferences;

public class ActivityRepository {

    private SharedPreferences sharedPreferences;

    public ActivityRepository(SharedPreferences sharedPreferences){
        this.sharedPreferences = sharedPreferences;
    }
}
