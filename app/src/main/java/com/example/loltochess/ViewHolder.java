package com.example.loltochess;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ViewHolder extends RecyclerView.ViewHolder {
    private View mView;
    public ImageView mItemImage, mStandard_image, mSecond_image;
    public TextView mTvWeapon, mTvWeaponSpec, mTvWeaponDamage, mTv_detail1;

    public ImageView mSynergyImage;
    public TextView mTvJob;
    public ImageView mTribeImage1;
    public ImageView mTribeImage2;
    public ImageView mTribeImage3;
    public ImageView mTribeImage4;
    public ImageView mTribeImage5;
    public ImageView mTribeImage6;
    public ImageView mTribeImage7;
    public ImageView mTribeImage8;
    public TextView mTvMainContents;
    public TextView mTvSubContent1;
    public TextView mTvSubContent2;
    public TextView mTvSubContent3;



    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view, getAdapterPosition());

            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListener.onItemlongClick(view, getAdapterPosition());
                return true;
            }
        });

    }

    public void setDetails(Context context, String itemImage, String tvWeapon, String tvWeaponSpec, String tvWeaponDamage) {
        this.mItemImage = mView.findViewById(R.id.itemImage);
        this.mTvWeapon = mView.findViewById(R.id.tvWeapon);
        this.mTvWeaponSpec = mView.findViewById(R.id.tvWeaponSpec);
        this.mTvWeaponDamage = mView.findViewById(R.id.tvWeaponDamage);

        mTvWeapon.setText(tvWeapon);
        mTvWeaponSpec.setText(tvWeaponSpec);
        mTvWeaponDamage.setText(tvWeaponDamage);
        // need cache // storage read/write permission --> "runtime permission"
        Glide.with(context).load(itemImage).into(mItemImage);

    }

    public void setDetailMdoel(Context context, String standard_image, String second_image, String tv_detail1) {
        mStandard_image = mView.findViewById(R.id.standard_image);
        mSecond_image = mView.findViewById(R.id.second_image);
        mTv_detail1 = mView.findViewById(R.id.tv_detail1);

        Glide.with(context).load(standard_image).into(mStandard_image);
        Glide.with(context).load(second_image).into(mSecond_image);
        mTv_detail1.setText(tv_detail1);

    }

    public void setTribeSynergyDetails(Context context, String synergyImage, String tvJob, String tribeImage1, String tribeImage2, String tribeImage3, String tribeImage4, String tribeImage5, String tribeImage6, String tribeImage7, String tribeImage8, String tvMainContents, String tvSubContent1, String tvSubContent2, String tvSubContent3) {
        mSynergyImage = mView.findViewById(R.id.synergyImage);
        mTvJob = mView.findViewById(R.id.tvJob);
        mTribeImage1 = mView.findViewById(R.id.tribeImage1);
        mTribeImage2 = mView.findViewById(R.id.tribeImage2);
        mTribeImage3 = mView.findViewById(R.id.tribeImage3);
        mTribeImage4 = mView.findViewById(R.id.tribeImage4);
        mTribeImage5 = mView.findViewById(R.id.tribeImage5);
        mTribeImage6 = mView.findViewById(R.id.tribeImage6);
        mTribeImage7 = mView.findViewById(R.id.tribeImage7);
        mTribeImage8 = mView.findViewById(R.id.tribeImage8);
        mTvMainContents = mView.findViewById(R.id.tvMainContents);
        mTvSubContent1 = mView.findViewById(R.id.tvSubContent1);
        mTvSubContent2 = mView.findViewById(R.id.tvSubContent2);
        mTvSubContent3 = mView.findViewById(R.id.tvSubContent3);

        Glide.with(context).load(synergyImage).into(mSynergyImage);
        mTvJob.setText(tvJob);
        Glide.with(context).load(tribeImage1).into(mTribeImage1);
        Glide.with(context).load(tribeImage2).into(mTribeImage2);
        Glide.with(context).load(tribeImage3).into(mTribeImage3);
        Glide.with(context).load(tribeImage4).into(mTribeImage4);
        Glide.with(context).load(tribeImage5).into(mTribeImage5);
        Glide.with(context).load(tribeImage6).into(mTribeImage6);
        Glide.with(context).load(tribeImage7).into(mTribeImage7);
        Glide.with(context).load(tribeImage8).into(mTribeImage8);
        mTvMainContents.setText(tvMainContents);
        mTvSubContent1.setText(tvSubContent1);
        mTvSubContent2.setText(tvSubContent2);
        mTvSubContent3.setText(tvSubContent3);


    }

    private ViewHolder.ClickListener mClickListener;

    //interface to send callbacks
    public interface ClickListener {
        void onItemClick(View view, int position);

        void onItemlongClick(View view, int position);

    }

    public void setOnClickListener(ViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;

    }
}