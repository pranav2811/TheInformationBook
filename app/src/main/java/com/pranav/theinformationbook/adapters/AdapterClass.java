package com.pranav.theinformationbook.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.pranav.theinformationbook.ModelClass;
import com.pranav.theinformationbook.R;
import com.pranav.theinformationbook.activities.CountriesActivity;
import com.pranav.theinformationbook.activities.LeadersActivity;
import com.pranav.theinformationbook.activities.MuseumsActivty;
import com.pranav.theinformationbook.activities.WondersActivity;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.CardViewHolder>{

    private ArrayList<ModelClass> modelList;
    private Context context;//using the context well be able to show the category pictures on the screen and open the fragments by clicking on then
    //to use the properties of the activity in this class


    public AdapterClass(ArrayList<ModelClass> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//this will determine which design will be displayed in the recyclerview
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design,parent,false);

        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, @SuppressLint("RecyclerView") int position) {//display data on the screen in reccyclerview
        //for this method we need to send the array list object we created in the main activity to the adapter class

        ModelClass model = modelList.get(position);
        //we use the holder object to access the textView and imageView contents as they are not directly accessible
        holder.textViewSplash.setText(model.getCategoryName());
        holder.imageViewSpash.setImageResource(context.getResources().getIdentifier(model.getImageName(),"drawable",context.getPackageName()));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 0){
                    Intent intent = new Intent(context, CountriesActivity.class);
                    context.startActivity(intent);
                }if(position == 1){
                    Intent intent = new Intent(context, LeadersActivity.class);
                    context.startActivity(intent);
                }if(position == 2){
                    Intent intent = new Intent(context, MuseumsActivty.class);
                    context.startActivity(intent);
                }if(position == 3){
                    Intent intent = new Intent(context, WondersActivity.class);
                    context.startActivity(intent);
                }


            }
        });

    }

    @Override
    public int getItemCount() {//specify the amount of data to be displayed in recycler view
        return modelList.size();//usually we write the size of the array we create
    }

    //this class will represent the card design

    public class CardViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageViewSpash;
        private TextView textViewSplash;
        private CardView cardView;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewSpash = itemView.findViewById(R.id.imageViewSplash);
            textViewSplash = itemView.findViewById(R.id.textViewSplash);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
