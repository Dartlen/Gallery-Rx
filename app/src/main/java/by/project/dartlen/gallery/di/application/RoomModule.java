package by.project.dartlen.gallery.di.application;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import by.project.dartlen.gallery.model.ImageDatabase;
import by.project.dartlen.gallery.model.db.ImageDao;
import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {
    private ImageDatabase imageDatabase;

    public RoomModule(Context context){
        imageDatabase = Room.databaseBuilder(context, ImageDatabase.class, "database.db").build();
    }

    @Provides
    @Singleton
    ImageDao provideImageDao(){
        return imageDatabase.imageDao();
    }
}
