package by.project.dartlen.gallery.ui.gallery;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;


import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.HashMap;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import by.project.dartlen.gallery.GalleryApp;
import by.project.dartlen.gallery.R;
import by.project.dartlen.gallery.business.gallery.GalleryInteractor;
import by.project.dartlen.gallery.model.entities.Image;
import by.project.dartlen.gallery.presentation.common.SchedulersProvider;
import by.project.dartlen.gallery.presentation.gallery.GalleryPresenter;
import by.project.dartlen.gallery.presentation.gallery.GalleryView;
import by.project.dartlen.gallery.ui.gallery.list.GalleryAdapter;

public class GalleryFragment extends MvpAppCompatFragment implements GalleryView{

    @InjectPresenter
    GalleryPresenter presenter;

    @Inject
    GalleryInteractor galleryInteractor;

    @Inject
    SchedulersProvider schedulersProvider;

    @Inject
    public GalleryFragment(){

    }

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.progressBar2)
    ProgressBar progressBar;

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Unbinder unbinder;
    private GalleryAdapter galleryAdapter;

    @ProvidePresenter
    GalleryPresenter providePresenter(){
        GalleryApp.getComponentsManager().getGalleryComponent().inject(this);
        return new GalleryPresenter(galleryInteractor, schedulersProvider);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gallery, container, false);
        setHasOptionsMenu(true);
        unbinder = ButterKnife.bind(this, v);
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);
        galleryAdapter = new GalleryAdapter();
        recyclerView.setAdapter(galleryAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle app bar item clicks here. The app bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.append:

                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showImages(HashMap<String, Image> list) {
        galleryAdapter.setImages(list);
    }
}
