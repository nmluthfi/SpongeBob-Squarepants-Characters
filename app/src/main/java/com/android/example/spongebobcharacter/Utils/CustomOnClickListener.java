package com.android.example.spongebobcharacter.Utils;

import android.view.View;

public class CustomOnClickListener implements View.OnClickListener {

    private int position;
    private OnItemClickCallBack onItemClickCallBack;

    @Override
    public void onClick(View view) {
        onItemClickCallBack.onItemClicked(view, position);
    }

    public interface OnItemClickCallBack{
        void onItemClicked(View view, int postion);
    }
}
