package com.malidielhadad.lasalle.network;

/**
 * Created by malidielhadad on 25/04/2017.
 */

class UrlBuilder {

    private static String baseUrl = "http://163.172.29.197:80000";
    private static String pathEvents = "events";

    public static String getAllEventsUrl() {
        return baseUrl+"/"+pathEvents;
    }
    public static String getEventUrl(String id) {
        return getAllEventsUrl()+"/"+id;
    }

    public static  String getCreateEventUrl() {
        return getAllEventsUrl();
    }

    public static String getDeleteEventUrl(String id) {
        return getAllEventsUrl()+"/"+id;
    }

    public static String getUpdateEventUrl(String id) {
        return getAllEventsUrl()+"/"+id;
    }

}
