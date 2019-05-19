package com.android.example.spongebobcharacter.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.example.spongebobcharacter.Model.Characters;
import com.android.example.spongebobcharacter.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridCharactersAdapter extends RecyclerView.Adapter<GridCharactersAdapter.CharactersViewHolder> {

    private Context mContext;
    private ArrayList<Characters> mData;

    public GridCharactersAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public ArrayList<Characters> getmData() {
        return mData;
    }

    public void setmData(ArrayList<Characters> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public CharactersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutResource = R.layout.item_grid_characters;
        ViewGroup root = viewGroup;
        boolean attachToRoot = false;

        View view = LayoutInflater.from(context).inflate(layoutResource, root, attachToRoot);
        return new CharactersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersViewHolder charactersViewHolder, int position) {
        Characters characters = mData.get(position);
        Glide.with(mContext)
                .load(characters.getmFoto())
                .apply(new RequestOptions().override(350, 350))
                .into(charactersViewHolder.imgCharaPhoto);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class CharactersViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCharaPhoto;

        public CharactersViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCharaPhoto = itemView.findViewById(R.id.iv_chara_photo);
        }
    }
}
