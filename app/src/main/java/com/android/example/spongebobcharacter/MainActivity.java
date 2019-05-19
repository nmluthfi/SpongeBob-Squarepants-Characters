package com.android.example.spongebobcharacter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.example.spongebobcharacter.Adapter.GridCharactersAdapter;
import com.android.example.spongebobcharacter.Adapter.RowCharactersAdapter;
import com.android.example.spongebobcharacter.Model.Characters;
import com.android.example.spongebobcharacter.Data.CharactersData;
import com.android.example.spongebobcharacter.Utils.ItemClickSupport;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rvCategory;
    private ArrayList<Characters> mData = new ArrayList<>();
    private String title = "Mode Row";
    private final String STATE_TITLE = "state_string", STATE_LIST = "state_list"
            , STATE_MODE = "state_mode";
    private int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_spongebob_characters);
        rvCategory.setHasFixedSize(true);

        mData.addAll(CharactersData.getListData());

        initRecyclerList();

    }

    private void initRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        RowCharactersAdapter rowCharactersAdapter = new RowCharactersAdapter(this);
        rowCharactersAdapter.setmData(mData);
        rvCategory.setAdapter(rowCharactersAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                openDetailActivity(mData.get(position));
            }
        });
    }

    private void initRecycleGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridCharactersAdapter gridCharactersAdapter = new GridCharactersAdapter(this);
        gridCharactersAdapter.setmData(mData);
        rvCategory.setAdapter(gridCharactersAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                openDetailActivity(mData.get(position));
            }
        });
    }

    private void openDetailActivity(Characters characters) {
        Class destinationClass = DetailActivity.class;
        Context context = MainActivity.this;
        Intent openDetailActivity = new Intent(context, destinationClass);
        openDetailActivity.putExtra(DetailActivity.EXTRA_NAME, characters.getmNama());
        openDetailActivity.putExtra(DetailActivity.EXTRA_DESCRIPTION, characters.getmDeskripsi());
        openDetailActivity.putExtra(DetailActivity.EXTRA_VOICE_OVER, characters.getmPengisiSuara());
        openDetailActivity.putExtra(DetailActivity.EXTRA_PHOTO, characters.getmFoto());
        startActivity(openDetailActivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selectedMenu = item.getItemId();
        switch (selectedMenu) {
            case R.id.action_row:
                initRecyclerList();
                return true;
            case R.id.action_grid:
                initRecycleGrid();
                return true;
            case R.id.action_card_View:
                Toast.makeText(this, "Mode cardview clicked", Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
