package com.example.loltochess.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loltochess.R;
import com.example.loltochess.Item.ReloadItem;
import com.example.loltochess.ViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReloadFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private FirebaseDatabase mFirebaseDatabase;
    public DatabaseReference mRef;
    private Activity activity;

    public ReloadFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final LinearLayout rootView = (LinearLayout) inflater.inflate(R.layout.fragment_reload, null);
        mRecyclerView = rootView.findViewById(R.id.recyclerviewReload);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("ReloadData");
        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FirebaseRecyclerAdapter<ReloadItem, ViewHolder> firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<ReloadItem, ViewHolder>(ReloadItem.class, R.layout.reload_item, ViewHolder.class, mRef) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, ReloadItem reloadItem, int i) {
                viewHolder.setReloadDetails(getActivity().getApplicationContext(), reloadItem.getTvLevel(), reloadItem.getTvTier1(), reloadItem.getTvTier2(), reloadItem.getTvTier3(), reloadItem.getTvTier4(), reloadItem.getTvTier5());

            }
        };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
