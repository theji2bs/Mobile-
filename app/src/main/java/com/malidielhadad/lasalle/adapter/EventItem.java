package com.malidielhadad.lasalle.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.malidielhadad.lasalle.R;
import com.malidielhadad.lasalle.model.Event;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.security.PublicKey;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by malidielhadad on 25/04/2017.
 */

public class EventItem extends AbstractItem<EventItem, EventItem.EventItemViewHolder> {


        private final Event event;

        public EventItem(Event event) {

            this.event = event;
        }
    @Override
    public EventItemViewHolder getViewHolder(View v) {

        return new EventItemViewHolder(v);

    }

    @Override
    public int getType() {

        return R.id.row_event_imageView;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.row_event;
    }

    @Override
    public void bindView(EventItemViewHolder holder, List<Object> payloads) {
        super.bindView(holder, payloads);

        holder.titleTextView.setText(event.getName());
        holder.datetextView.setText(event.getCreatedAt());
    }

    protected static class EventItemViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.row_event_imageView)
        ImageView imageView;

        @BindView(R.id.row_event_title_textView)
        TextView titleTextView;

        @BindView(R.id.row_event_date_textView)
        TextView datetextView;

        public EventItemViewHolder(View itemView) {
            super(itemView);

            // Bind with ButterKnife

            ButterKnife.bind(this, itemView);
        }
    }
}
