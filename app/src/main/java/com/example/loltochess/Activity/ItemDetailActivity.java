package com.example.loltochess.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.loltochess.Item.DetailItem;
import com.example.loltochess.R;
import com.example.loltochess.ViewHolder;
import com.example.loltochess.ViewHolderNon;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Ref;

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
        final String weapon = getIntent().getStringExtra("weapon");
        String weaponSpec = getIntent().getStringExtra("weaponSpec");
        String weaponDamage = getIntent().getStringExtra("weaponDamage");

        Glide.with(getApplicationContext()).load(image).into(mainImage_detail);
        tvWeapon_detail.setText(weapon);
        tvWeaponSpec_detail.setText(weaponSpec);
        tvWeaponDamage_detail.setText(weaponDamage);


        detail_item_recyclerView = (RecyclerView) findViewById(R.id.detail_item_recyclerView);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
//        mRef = mFirebaseDatabase.getReference().child("DataDetail").child(String.valueOf(tvWeapon_detail));
        if (weapon.equals("B.F.대검")) {
            mRef = mFirebaseDatabase.getReference().child("DataDetail");
        } else if (weapon.equals("곡궁")) {
            mRef = mFirebaseDatabase.getReference().child("DataDetail2");
        } else if (weapon.equals("쇠사슬 조끼")) {
            mRef = mFirebaseDatabase.getReference().child("DataDetail3");
        } else if (weapon.equals("음전자 망토")) {
            mRef = mFirebaseDatabase.getReference().child("DataDetail4");
        } else if (weapon.equals("쓸데없이 큰 지팡이")) {
            mRef = mFirebaseDatabase.getReference().child("DataDetail5");
        } else if (weapon.equals("여신의 눈물")) {
            mRef = mFirebaseDatabase.getReference().child("DataDetail6");
        } else if (weapon.equals("거인의 허리띠")) {
            mRef = mFirebaseDatabase.getReference().child("DataDetail7");
        } else if (weapon.equals("뒤집개")) {
            mRef = mFirebaseDatabase.getReference().child("DataDetail8");
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();

        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAdapter();


    }

    public void firebaseAdapter() {
        FirebaseRecyclerAdapter<DetailItem, ViewHolderNon> firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<DetailItem, ViewHolderNon>(DetailItem.class, R.layout.detail_item, ViewHolderNon.class, mRef) {
            @Override
            protected void populateViewHolder(ViewHolderNon viewHolderNon, DetailItem detailItem, int i) {

                viewHolderNon.setDetailMdoel(getApplicationContext(), detailItem.getStandard_image(), detailItem.getSecond_image(), detailItem.getTv_detail1());

            }

        };
        detail_item_recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

}
