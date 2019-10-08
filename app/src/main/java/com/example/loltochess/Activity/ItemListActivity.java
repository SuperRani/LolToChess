package com.example.loltochess.Activity;



import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loltochess.Item.Item;
import com.example.loltochess.R;
import com.example.loltochess.ViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class ItemListActivity extends AppCompatActivity {
    private RecyclerView item_recyclerView;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        item_recyclerView = (RecyclerView) findViewById(R.id.item_recyclerView);
//        item_recyclerView.setHasFixedSize(true);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Data");
    }

    private void firebaseSearc(String searchText){
        Query firebaseSearchQuery = mRef.orderByChild("tvWeapon").startAt(searchText).endAt(searchText + "\uf8ff");
        FirebaseRecyclerAdapter<Item, ViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Item, ViewHolder>(Item.class, R.layout.item, ViewHolder.class, firebaseSearchQuery) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, Item item, int i) {
                viewHolder.setDetails(getApplicationContext(), item.getItemImage(), item.getTvWeapon(), item.getTvWeaponSpec(), item.getTvWeaponDamage());

            }
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
                viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String mMainImage_detail = getItem(position).getItemImage();
                        String mTvWeapon_detail = getItem(position).getTvWeapon();
                        String mTvWeaponSpec_detail = getItem(position).getTvWeaponSpec();
                        String mTvWeaponDamage_detail = getItem(position).getTvWeaponDamage();

                        Intent i = new Intent(view.getContext(), ItemDetailActivity.class);
                        i.putExtra("image", mMainImage_detail);
                        i.putExtra("weapon", mTvWeapon_detail);
                        i.putExtra("weaponSpec", mTvWeaponSpec_detail);
                        i.putExtra("weaponDamage", mTvWeaponDamage_detail);
                        startActivity(i);

                    }
                    @Override
                    public void onItemlongClick(View view, int position) {

                    }
                });
                return viewHolder;
            }
        };
        item_recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Item, ViewHolder> firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<Item, ViewHolder>(Item.class, R.layout.item, ViewHolder.class, mRef) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, Item item, int position) {
                viewHolder.setDetails(getApplicationContext(), item.getItemImage(), item.getTvWeapon(), item.getTvWeaponSpec(), item.getTvWeaponDamage());
            }

            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
                viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String mMainImage_detail = getItem(position).getItemImage();
                        String mTvWeapon_detail = getItem(position).getTvWeapon();
                        String mTvWeaponSpec_detail = getItem(position).getTvWeaponSpec();
                        String mTvWeaponDamage_detail = getItem(position).getTvWeaponDamage();
                     


                        Intent i = new Intent(view.getContext(), ItemDetailActivity.class);
                        i.putExtra("image", mMainImage_detail);
                        i.putExtra("weapon", mTvWeapon_detail);
                        i.putExtra("weaponSpec", mTvWeaponSpec_detail);
                        i.putExtra("weaponDamage", mTvWeaponDamage_detail);
                        startActivity(i);

                    }

                    @Override
                    public void onItemlongClick(View view, int position) {

                    }
                });
                return viewHolder;
            }
        };
        item_recyclerView.setAdapter(firebaseRecyclerAdapter);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem item  = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                firebaseSearc(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                firebaseSearc(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if( id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void clickToCreateView() {
    }
}
