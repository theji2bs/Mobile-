package com.malidielhadad.lasalle.network;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.malidielhadad.lasalle.LasalleApp;
import com.malidielhadad.lasalle.model.Event;
import com.malidielhadad.lasalle.model.EventResult;
import com.malidielhadad.lasalle.model.EventResults;
import com.neopixl.library.spitfire.listener.RequestListener;
import com.neopixl.library.spitfire.request.BaseRequest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by malidielhadad on 25/04/2017.
 */

public class EventManager {

    public static EventManager listener;


    public interface Listener<T> {
        void onReceived(T result);
        void onFailed();
    }

  /*
    public interface EventManagerListener{
        void onEventsReceived(List<Event> events);
        void onEventsFailed();

    }

    public interface EventListener {
        void onEventsReceived(Event event);
        void onEventsFailed();
    } */

    public static void getAllEvents(final Listener<List<Event>> listener) {

        String url = UrlBuilder.getAllEventsUrl();


        BaseRequest.Builder<EventResults> resultBuilder =
                new BaseRequest.Builder<>(com.android.volley.Request.Method.GET, url, EventResults.class);
        resultBuilder.listener(new RequestListener<EventResults>() {
                                   @Override

                                   public void onSuccess(EventResults eventResults) {
                                       if(listener!=null){
                                           listener.onReceived(Arrays.asList(eventResults.getData()));
                                       }

                                   }

                                   @Override
                                   public void onFailure(VolleyError volleyError, int i) {
                                       if(listener!= null) {
                                           listener.onFailed();
                                       }

                                   }
                               });


        LasalleApp
                .getSharedInstance()
                .getRequestQueue()
                .add(resultBuilder.build());

    }

    public static void getEvent(String eventId, final Listener<Event> listener) {

        String url = UrlBuilder.getEventUrl(eventId);

        BaseRequest.Builder<EventResult> resultBuilder =
            new BaseRequest.Builder<>(com.android.volley.Request.Method.GET, url, EventResult.class);
        resultBuilder.listener(new RequestListener<EventResult>(){
            @Override

            public void onSuccess(EventResult eventResult) {
                if(listener!=null){
                    listener.onReceived(eventResult.getEvent());
                }

            }

            @Override
            public void onFailure(VolleyError volleyError, int i) {
                if(listener!= null) {
                    listener.onFailed();
                }

            }

        });



/*
            @Override
            public JavaType getReturnType() {
                return SimpleType.constructUnsafe(EventResult.class);
            }
        }); */

        LasalleApp
                .getSharedInstance()
                .getRequestQueue()
                .add(resultBuilder.build());
    }


    public static void createEvent(Event event) {
        String url = UrlBuilder.getCreateEventUrl();


        BaseRequest.Builder<EventResult> resultBuilder =
                new BaseRequest.Builder<>(com.android.volley.Request.Method.POST, url, EventResult.class);


        resultBuilder.object(event);

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        resultBuilder
                .headers(headers)
                .listener(new RequestListener<EventResult>() {
            @Override
            public void onSuccess(EventResult eventResult) {
                eventResult.getClass();

            }

            @Override
            public void onFailure(VolleyError volleyError, int i) {

            }
        });

        LasalleApp.getSharedInstance()
                .getRequestQueue()
                .add(resultBuilder.build());



    }
}
