package com.example.loltochess;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ItemDetailActivity extends AppCompatActivity {
    public ImageView mainImage_detail;
    public TextView tvWeapon_detail, tvWeaponSpec_detail, tvWeaponDamage_detail;

    public RecyclerView detail_item_recyclerView;
    public FirebaseDatabase mFirebaseDatabase;
    public DatabaseReference mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        //action bar
        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("Item Detail");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        mainImage_detail = findViewById(R.id.mainImage_detail);
        tvWeapon_detail = findViewById(R.id.tvWeapon_detail);
        tvWeaponSpec_detail = findViewById(R.id.tvWeaponSpec_detail);
        tvWeaponDamage_detail = findViewById(R.id.tvWeaponDamage_detail);

        String image = getIntent().getStringExtra("image");
        String weapon = getIntent().getStringExtra("weapon");
        String weaponSpec = getIntent().getStringExtra("weaponSpec");
        String weaponDamage = getIntent().getStringExtra("weaponDamage");

        Glide.with(getApplicationContext()).load(image).into(mainImage_detail);
        tvWeapon_detail.setText(weapon);
        tvWeaponSpec_detail.setText(weaponSpec);
        tvWeaponDamage_detail.setText(weaponDamage);

        detail_item_recyclerView = (RecyclerView)findViewById(R.id.detail_item_recyclerView);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("DataDetail");



    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();

        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<DetailItem, ViewHolder> firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<DetailItem, ViewHolder>(DetailItem.class, R.layout.detail_item, ViewHolder.class, mRef) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, DetailItem detailItem, int i) {
                viewHolder.setDetailMdoel(getApplicationContext(), detailItem.getStandard_image(), detailItem.getSecond_image(), detailItem.getTv_detail1());
            }
        };
        detail_item_recyclerView.setAdapter(firebaseRecyclerAdapter);

    }
}
