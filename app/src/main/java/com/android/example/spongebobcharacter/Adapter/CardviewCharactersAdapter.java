package com.android.example.spongebobcharacter.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.example.spongebobcharacter.Model.Characters;
import com.android.example.spongebobcharacter.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardviewCharactersAdapter
        extends RecyclerView.Adapter<CardviewCharactersAdapter.CharactersViewHolder> {

    private Context mContext;
    private ArrayList<Characters> mData;

    public CardviewCharactersAdapter(Context mContext) {
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
        int layoutResource = R.layout.item_cardview_characters;
        ViewGroup root = viewGroup;
        boolean attachToRoot = false;

        View view = LayoutInflater.from(context).inflate(layoutResource, root, attachToRoot);
        return new CharactersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersViewHolder charactersViewHolder, int position) {
        final Characters characters = mData.get(position);
        charactersViewHolder.tvCharaNama.setText(characters.getmNama());
        charactersViewHolder.tvCharaVoiceOver.setText(characters.getmPengisiSuara());
        Glide.with(mContext)
                .load(characters.getmFoto())
                .apply(new RequestOptions().override(60, 60))
                .into(charactersViewHolder.ivCharaPhto);

        charactersViewHolder.ibFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Kamu suka " + characters.getmNama()
                        , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class CharactersViewHolder extends RecyclerView.ViewHolder {

        TextView tvCharaNama, tvCharaVoiceOver;
        ImageButton ibFavorite;
        ImageView ivCharaPhto;

        public CharactersViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCharaNama = itemView.findViewById(R.id.tv_chara_name);
            tvCharaVoiceOver = itemView.findViewById(R.id.tv_chara_voice_over);
            ibFavorite = itemView.findViewById(R.id.ib_favorite);
            ivCharaPhto = itemView.findViewById(R.id.civ_chara_photo);
        }
    }
}
