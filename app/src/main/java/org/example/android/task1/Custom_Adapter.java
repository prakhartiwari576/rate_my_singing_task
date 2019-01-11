package org.example.android.task1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Custom_Adapter extends RecyclerView.Adapter<Custom_Adapter.MyViewHolder> {

    private final List<Custom_Container> bakeries;
    private Context context;

    public Custom_Adapter(Context context, List<Custom_Container> bakeries) {
        this.bakeries = bakeries;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Custom_Container bakery = bakeries.get(position);
        holder.name.setText(bakery.GetName());
        holder.age.setText(bakery.GetAge());
    }

    @Override
    public int getItemCount() {
        return this.bakeries.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, age;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.id_name);
            age = itemView.findViewById(R.id.id_age);
        }
    }
}