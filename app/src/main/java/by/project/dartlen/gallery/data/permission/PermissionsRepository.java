package by.project.dartlen.gallery.data.permission;

import android.Manifest;

import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.Observable;


public class PermissionsRepository {


    private RxPermissions rxPermissions;

    public PermissionsRepository(RxPermissions rxPermissions){
        this.rxPermissions = rxPermissions;
    }

    public Observable<Boolean> requestLocationPermissions(){
        return rxPermissions.request(Manifest.permission.ACCESS_COARSE_LOCATION);
    }
}
