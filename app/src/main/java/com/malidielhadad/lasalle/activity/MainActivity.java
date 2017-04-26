package com.malidielhadad.lasalle.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.malidielhadad.lasalle.R;
import com.malidielhadad.lasalle.model.Event;
import com.malidielhadad.lasalle.network.EventManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.menu_create:
                Event event = new Event();
                event.setName("OKLM");
                event.setImageUrl("https://i.ytimg.com/vi/ZBrP54B0YMY/hqdefault.jpg");
                event.setDescription("Il faut les prendre par la cha*******");
                event.setInformation("oklm");
                Event.Location location = new Event.Location();
                location.setLatitude(48.852563);
                location.setLongitude(2.4456886675587);

                event.setLocation(location);

                EventManager.createEvent(event);


        }
        return super.onOptionsItemSelected(item);
    }
}
