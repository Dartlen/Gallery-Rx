package by.project.dartlen.gallery.di.application;

import android.content.Context;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FirebaseModule {
    private DatabaseReference databaseReference;
    private StorageReference storageReference;

    public FirebaseModule(){
        databaseReference = FirebaseDatabase.getInstance().getReference("images");
        storageReference = FirebaseStorage.getInstance().getReference();
    }

    @Provides
    @Singleton
    DatabaseReference provideDatabaseReference(){
        return databaseReference;
    }

    @Provides
    @Singleton
    StorageReference provideStorageReference(){
        return storageReference;
    }
}
