package com.example.scratch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentAnunturi extends Fragment {

    private RecyclerView mRecyclerView;
    private AnuntAdapter mAdapter;
    private AnuntViewModel mAnuntViewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anunt, container, false);

        mRecyclerView = view.findViewById(R.id.recycler_view);
        mAdapter = new AnuntAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAnuntViewModel = new ViewModelProvider(this).get(AnuntViewModel.class);

        return view;
    }

    // ...

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAnuntViewModel.getAllAnunts().observe(getViewLifecycleOwner(), new Observer<List<Anunt>>() {
            @Override
            public void onChanged(List<Anunt> anunts) {
                mAdapter.setAnunts(anunts);
            }
        });
    }


}