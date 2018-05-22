package by.project.dartlen.gallery.ui.gallery.list;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.project.dartlen.gallery.R;
import by.project.dartlen.gallery.model.entities.Image;

public class GalleryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private HashMap<String, Image> list =new HashMap<>(0);

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_holder, parent, false);
        return new ImageHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ImageHolder)holder).bindImage(list.get("-L1gjUD-f1HGnIuCvN27").getUrl());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setImages(HashMap<String, Image> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public static class ImageHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imageView)
        SimpleDraweeView imageView;

        ImageHolder(View v){
            super(v);
            ButterKnife.bind(this, v);
        }

        void bindImage(String url){
            imageView.setImageURI(url);
        }
    }
}


