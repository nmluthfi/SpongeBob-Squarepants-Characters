package com.android.example.spongebobcharacter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.example.spongebobcharacter.Adapter.RowCharactersAdapter;
import com.android.example.spongebobcharacter.Data.Characters;
import com.android.example.spongebobcharacter.Data.CharactersData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rvCategory;
    private ArrayList<Characters> mData = new ArrayList<>();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_spongebob_characters);
        mData.addAll(CharactersData.getListData());
        initRecyclerList();

    }

    private void initRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        RowCharactersAdapter rowCharactersAdapter = new RowCharactersAdapter(this);
        rowCharactersAdapter.setmData(mData);
        rvCategory.setHasFixedSize(true);
        rvCategory.setAdapter(rowCharactersAdapter);
    }
}
