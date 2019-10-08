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
import com.example.loltochess.Item.TribeSynergyItem;
import com.example.loltochess.ViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecondFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private FirebaseDatabase mFirebaseDatabase;
    public DatabaseReference mRef;
    private Activity activity;

    public SecondFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final LinearLayout rootView = (LinearLayout) inflater.inflate(R.layout.fragment_second, null);
        mRecyclerView = rootView.findViewById(R.id.recyclerviewTab2);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("SynergyData2");
        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FirebaseRecyclerAdapter<TribeSynergyItem, ViewHolder> firebaseRecyclerAdapter
                =  new FirebaseRecyclerAdapter<TribeSynergyItem, ViewHolder>(TribeSynergyItem.class, R.layout.tribe_synergy_item,ViewHolder.class, mRef ) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, TribeSynergyItem tribeSynergyItem, int i) {
                viewHolder.setTribeSynergyDetails(getActivity().getApplicationContext(), tribeSynergyItem.getSynergyImage(), tribeSynergyItem.getTvJob(),
                        tribeSynergyItem.getTribeImage1(), tribeSynergyItem.getTribeImage2(), tribeSynergyItem.getTribeImage3(),tribeSynergyItem.getTribeImage4(),
                        tribeSynergyItem.getTribeImage5(),tribeSynergyItem.getTribeImage6(),tribeSynergyItem.getTribeImage7(),tribeSynergyItem.getTribeImage8(),
                        tribeSynergyItem.getTvMainContents(), tribeSynergyItem.getTvSubContent1(),tribeSynergyItem.getTvSubContent2(),tribeSynergyItem.getTvSubContent3());
            }
        };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
