package com.example.nodo.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nodo.R;
import com.example.nodo.model.NoDo;

import java.util.List;

public class NoDoListAdapter extends RecyclerView.Adapter<NoDoListAdapter.NoDoViewHolder>{
    private final LayoutInflater nodoInflater;
    private List<NoDo> noDoList;

    public NoDoListAdapter(Context context) {
        this.nodoInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NoDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = nodoInflater.inflate(R.layout.recycler_item, parent, false);
        return new NoDoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoDoViewHolder holder, int position) {
        if (noDoList != null) {
            NoDo current = noDoList.get(position);
            holder.nodoText.setText(current.getNodo());
        }
        else {
            holder.nodoText.setText(R.string.not_nodo);
        }

    }
    public void setNoDoList(List<NoDo> noDos) {
        noDoList = noDos;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (noDoList != null)
            return noDoList.size();
        else return 0;
    }

    public class NoDoViewHolder extends RecyclerView.ViewHolder{
        public TextView nodoText;
        public NoDoViewHolder(@NonNull View itemView) {
            super(itemView);
            nodoText = itemView.findViewById(R.id.textView);
        }
    }
}
