package by.project.dartlen.gallery.repositories.gallery;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.List;

import by.project.dartlen.gallery.model.db.ImageDao;
import by.project.dartlen.gallery.model.entities.Image;
import by.project.dartlen.gallery.model.mappers.GalleryMapper;
import io.reactivex.Single;

public class GalleryRepository {

    private GalleryMapper galleryMapper;
    private ImageDao imageDao;
    private DatabaseReference databaseReference;
    private StorageReference storageReference;

    public GalleryRepository(GalleryMapper galleryMapper, ImageDao imageDao, DatabaseReference databaseReference,
                             StorageReference storageReference){
        this.galleryMapper = galleryMapper;
        this.imageDao = imageDao;
        this.databaseReference = databaseReference;
        this.storageReference = storageReference;
    }

    public Single<HashMap<String, Image>> getImages(){
        return Single.create(emitter -> {
            databaseReference.child("K7lAQUZXMHUdUU5UvPMZWCNdmGu1").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    GenericTypeIndicator<HashMap<String, Image>> listImages = new GenericTypeIndicator<HashMap<String, Image>>(){};
                    HashMap<String, Image> result = dataSnapshot.getValue(listImages);
                    if(result!=null){
                        emitter.onSuccess(result);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    emitter.onError(new Throwable());
                }
            });
        });
    }
}
