package com.malidielhadad.lasalle.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.malidielhadad.lasalle.R;
import com.malidielhadad.lasalle.adapter.EventItem;
import com.malidielhadad.lasalle.model.Event;
import com.malidielhadad.lasalle.network.EventManager;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsListFragement extends Fragment {


    @BindView(R.id.recyclerview_events)
    RecyclerView eventsRecylerView;
    private FastItemAdapter<EventItem> eventsAdapter;


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
    @Override
    public void onStart(){
        super.onStart();

        eventsAdapter = new FastItemAdapter<>();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        eventsRecylerView.setLayoutManager(linearLayoutManager);


        eventsRecylerView.setAdapter(eventsAdapter);


        EventManager.getAllEvents(new EventManager.EventManagerListener() {
            @Override
            public void onEventsReceived(List<Event> events) {

                List<EventItem> items = new ArrayList<>();

                for(Event event : events) {
                    items.add(new EventItem(event));
                }

                eventsAdapter.add(items);


            }

            @Override
            public void onEventsFailed() {

            }
        });
    }

}
