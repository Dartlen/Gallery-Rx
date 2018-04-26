package by.project.dartlen.gallery.di.application;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.android.gms.common.GoogleApiAvailability;
import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Singleton;

import by.project.dartlen.gallery.business.ActivityInteractor;
import by.project.dartlen.gallery.data.permission.PermissionsRepository;
import by.project.dartlen.gallery.repositories.activity.ActivityRepository;
import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class AppModule {
    private static final String APP_PREFS = "AppPrefs";
    private Context context;

    public AppModule(Context aContext){
        context = aContext.getApplicationContext();
    }

    @Provides
    @Singleton
    Context provideAppContext(){
        return context;
    }

    @Provides
    @Singleton
    SharedPreferences  provideSharedPreference(){
        return context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    PermissionsRepository providePermissionsManager(RxPermissions rxPermissions){
        return new PermissionsRepository(rxPermissions);
    }

    @Provides
    @Singleton
    RxPermissions provideRxPermissions(Context context){
        return RxPermissions.getInstance(context);
    }

    @Provides
    @Singleton
    GoogleApiAvailability provideGoogleApiAvailability(){
        return GoogleApiAvailability.getInstance();
    }

    @Provides
    @Singleton
    ActivityInteractor provideInteractor(ActivityRepository repository){
        return new ActivityInteractor(repository);
    }

    @Provides
    @Singleton
    ActivityRepository provideActivityRepository(SharedPreferences sharedPreferences){
        return new ActivityRepository(sharedPreferences);
    }
}
