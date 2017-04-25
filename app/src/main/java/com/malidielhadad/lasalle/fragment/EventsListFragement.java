package com.malidielhadad.lasalle.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.malidielhadad.lasalle.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsListFragement extends Fragment {


    @BindView(R.id.recyclerview_events)
    RecyclerView eventsRecylerView;


    public EventsListFragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_events_list_fragement, container, false);

        // Pour intercepter le clique seulement le plus haut
        rootView.setClickable(true);

        ButterKnife.bind(this, rootView);

        return rootView;
    }

}
