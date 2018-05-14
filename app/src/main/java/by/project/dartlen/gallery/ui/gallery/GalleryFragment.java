package by.project.dartlen.gallery.ui.gallery;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import by.project.dartlen.gallery.GalleryApp;
import by.project.dartlen.gallery.R;
import by.project.dartlen.gallery.business.gallery.GalleryInteractor;
import by.project.dartlen.gallery.presentation.gallery.GalleryPresenter;
import by.project.dartlen.gallery.presentation.gallery.GalleryView;
import by.project.dartlen.gallery.repositories.gallery.GalleryRepository;
import by.project.dartlen.gallery.ui.gallery.list.GalleryAdapter;

public class GalleryFragment extends MvpAppCompatFragment implements GalleryView{

    @InjectPresenter
    GalleryPresenter presenter;

    /*@Inject
    GalleryInteractor galleryInteractor;*/

    @Inject
    public GalleryFragment(){

    }

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.progressBar2)
    ProgressBar progressBar;

    private Unbinder unbinder;

    @ProvidePresenter
    GalleryPresenter providePresenter(){
        GalleryApp.getComponentsManager().getAppComponent().inject(this);
        return new GalleryPresenter(new GalleryInteractor(new GalleryRepository()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gallery, container, false);

        unbinder = ButterKnife.bind(this, v);

        GalleryAdapter galleryAdapter = new GalleryAdapter();
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
}
