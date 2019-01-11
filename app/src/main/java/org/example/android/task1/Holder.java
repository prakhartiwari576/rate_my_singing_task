package org.example.android.task1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Holder extends RecyclerView.ViewHolder{

    private final TextView NName;
    private final TextView AAge;

    private Custom_Container var;
    private Context context;

    public Holder(Context context, View itemView) {

        super(itemView);

        // 1. Set the context
        this.context = context;

        // 2. Set up the UI widgets of the holder

        this.NName = (TextView) itemView.findViewById(R.id.id_name);
        this.AAge = (TextView) itemView.findViewById(R.id.id_age);
    }

    public void bind(Custom_Container bakery) {

        // 4. Bind the data to the ViewHolder
        this.var = bakery;
        this.NName.setText(bakery.GetName());
        this.AAge.setText(bakery.GetAge());
    }
}
