package by.project.dartlen.gallery.model.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import by.project.dartlen.gallery.model.entities.ImageEntity;

@Dao
public interface ImageDao {

    @Query("SELECT * FROM images")
    List<ImageEntity> loadImages();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveImages(List<ImageEntity> imageEntities);

    @Query("SELECT * FROM images WHERE id=:id")
    ImageEntity getImages(int id);

}
