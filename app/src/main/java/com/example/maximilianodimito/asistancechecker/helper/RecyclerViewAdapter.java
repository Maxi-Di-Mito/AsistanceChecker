package com.example.maximilianodimito.asistancechecker.helper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.maximilianodimito.asistancechecker.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by maximiliano.dimito on 8/30/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<String> items;
    private Context context;

    public RecyclerViewAdapter(List items, Context context){
        this.items = items;
        this.context = context;
    }

    public void clear(){
        items.clear();
    }

    public void add(String s){
        items.add(s);
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.items_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.text1)
        TextView textView;

        public ViewHolder(View v){
            super(v);
            ButterKnife.bind(this,v);
        }
    }
}
