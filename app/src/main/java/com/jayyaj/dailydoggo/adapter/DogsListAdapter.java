package com.jayyaj.dailydoggo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jayyaj.dailydoggo.R;
import com.jayyaj.dailydoggo.model.DogBreed;

import java.util.List;

public class DogsListAdapter extends RecyclerView.Adapter<DogsListAdapter.ViewHolder> {
    private List<DogBreed> dogsList;
    private OnDogClickListener onDogClickListener;

    public DogsListAdapter(List<DogBreed> dogsList, OnDogClickListener onDogClickListener) {
        this.dogsList = dogsList;
        this.onDogClickListener = onDogClickListener;
    }

    public void updateDogsList(List<DogBreed> updatedDogsList) {
        dogsList.clear();
        dogsList.addAll(updatedDogsList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dog_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DogBreed dogBreed = dogsList.get(position);
        holder.dogRowName.setText(dogBreed.getDogBreed());
        holder.dogRowLifespan.setText(dogBreed.getLifeSpan());
    }

    @Override
    public int getItemCount() {
        return dogsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView dogRowName;
        public TextView dogRowLifespan;
        public ImageView dogRowImage;
        public OnDogClickListener dogClickListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dogRowName = itemView.findViewById(R.id.dogRowName);
            dogRowLifespan = itemView.findViewById(R.id.dogRowLifespan);
            dogRowImage = itemView.findViewById(R.id.dogRowImage);
            this.dogClickListener = onDogClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            DogBreed dogBreed = dogsList.get(getAdapterPosition());
            onDogClickListener.onDogClicked(dogBreed);
        }
    }
}
