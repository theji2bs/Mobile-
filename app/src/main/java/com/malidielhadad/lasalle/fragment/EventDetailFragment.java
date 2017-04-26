package com.malidielhadad.lasalle.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.malidielhadad.lasalle.R;
import com.malidielhadad.lasalle.model.Event;
import com.malidielhadad.lasalle.network.EventManager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventDetailFragment extends BaseFragment {


    @BindView(R.id.title_textView)
    TextView titleTextView;

    @BindView(R.id.date_textView)
            TextView dateTextView;

    @BindView(R.id.place_textView)
        TextView placeTextView;

    @BindView(R.id.description_textView)
        TextView descriptionTextView;


    private static final String ARGUMENTS_EVENT_ID = "event_id";


    public static EventDetailFragment newInstance(String eventId){
        EventDetailFragment fragment = new EventDetailFragment();
        fragment.setEventId(eventId);

        return fragment;

    }


    public EventDetailFragment() {
        // Required empty public constructor

        Bundle arguments = new Bundle();
        setArguments(arguments);
    }

    public void setEventId(String eventId){

        Bundle arguments = getArguments();
        arguments.putString(ARGUMENTS_EVENT_ID, eventId);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_event_detail, container, false);


        rootView.setClickable(true);

        ButterKnife.bind(this, rootView);

                return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        String eventId = getArguments().getString(ARGUMENTS_EVENT_ID);

        showLoading();

        EventManager.getEvent(eventId, new EventManager.Listener<Event>() {
            @Override
            public void onReceived(Event result) {
                refresh(result);
                hideLoading();

            }

            @Override
            public void onFailed() {
                hideLoading();

            }
        });
    }

    private void refresh(Event event) {
        titleTextView.setText(event.getName());
        dateTextView.setText(event.getCreatedAt());

        // placetextView.setText(event.get);

        descriptionTextView.setText(event.getDescription());
    }
}
