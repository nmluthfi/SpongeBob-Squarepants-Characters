package com.android.example.spongebobcharacter;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra_name", EXTRA_DESCRIPTION = "extra_description"
        , EXTRA_VOICE_OVER = "extra_voice_over", EXTRA_PHOTO = "extra_photo";

    private TextView tvCharaName, tvCharaDescription, tvCharaVoiceOver;
    private ImageView ivCharaPhoto;

    private String nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initComponent();

        Intent intentThatStartThisActivity = getIntent();
        if (intentThatStartThisActivity != null) {
            nama = intentThatStartThisActivity.getStringExtra(EXTRA_NAME);
            String description = intentThatStartThisActivity.getStringExtra(EXTRA_DESCRIPTION);
            String voiceOver = intentThatStartThisActivity.getStringExtra(EXTRA_VOICE_OVER);
            String photo = intentThatStartThisActivity.getStringExtra(EXTRA_PHOTO);

            tvCharaName.setText(nama);
            tvCharaVoiceOver.setText(voiceOver);
            tvCharaDescription.setText(description);
            Glide.with(this)
                    .load(photo)
                    .apply(new RequestOptions().override(100, 100))
                    .into(ivCharaPhoto);
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(nama);
        }
    }

    private void initComponent() {
        tvCharaDescription = findViewById(R.id.tv_chara_description);
        tvCharaName = findViewById(R.id.tv_chara_name);
        tvCharaVoiceOver = findViewById(R.id.tv_chara_voice_over);
        ivCharaPhoto = findViewById(R.id.civ_chara_photo);
    }
}
