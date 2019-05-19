package com.android.example.spongebobcharacter.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.example.spongebobcharacter.Model.Characters;
import com.android.example.spongebobcharacter.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class RowCharactersAdapter
        extends RecyclerView.Adapter<RowCharactersAdapter.CharactersViewHolder> {

    private Context mContext;
    private ArrayList<Characters> mData;

    public RowCharactersAdapter(Context mContext) {
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
    public RowCharactersAdapter.CharactersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup
            , int viewTyep) {
        Context context = viewGroup.getContext();
        int layoutResource = R.layout.item_row_characters;
        ViewGroup root = viewGroup;
        boolean attachToRoot = false;

        View view = LayoutInflater.from(context).inflate(layoutResource, root, attachToRoot);
        return new CharactersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowCharactersAdapter.CharactersViewHolder charactersViewHolder
            , int position) {
        charactersViewHolder.tvCharaName.setText(getmData().get(position).getmNama());
        charactersViewHolder.tvCharaVoiceOver.setText("Pengisi suara: " + getmData().get(position).getmPengisiSuara());
        Glide.with(mContext)
                .load(getmData().get(position).getmFoto())
                .apply(new RequestOptions().override(60, 60))
                .into(charactersViewHolder.imgCharaFoto);
    }

    @Override
    public int getItemCount() {
        return getmData().size();
    }

    public class CharactersViewHolder extends RecyclerView.ViewHolder {

        TextView tvCharaName, tvCharaVoiceOver;
        ImageView imgCharaFoto;

        public CharactersViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCharaName = itemView.findViewById(R.id.tv_chara_name);
            tvCharaVoiceOver = itemView.findViewById(R.id.tv_chara_voice_over);
            imgCharaFoto = itemView.findViewById(R.id.civ_chara_photo);
        }
    }


}
