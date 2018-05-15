package by.project.dartlen.gallery.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import by.project.dartlen.gallery.model.db.ImageDao;
import by.project.dartlen.gallery.model.entities.ImageEntity;

@Database(entities = {ImageEntity.class}, version = 2, exportSchema = false)
public abstract class ImageDatabase extends RoomDatabase {
    public abstract ImageDao imageDao();
}
