package com.pranav.theinformationbook.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pranav.theinformationbook.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class FragmentIndia extends Fragment {


    public static FragmentIndia newInstance(){
        return new FragmentIndia();
    }
    private ImageView imageViewIndia;
    private ProgressBar progressBarIndia;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //using inflater object we will define our design
        //ViewGroup represents the activity to which well bind our activity
        //bundle states whether we can create it from any situation we saved before

        View view = inflater.inflate(R.layout.fragment_india, container,false);

        imageViewIndia = view.findViewById(R.id.imageViewIndia);
        progressBarIndia = view.findViewById(R.id.progressBarIndia);
        //we need to create an instance from this class using which well be able to use our instance in the view page adapter

        //using picasso we can load the images from the web using their image address
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/4/41" +
                        "/Flag_of_India.svg/188px-Flag_of_India.svg.png")
                .into(imageViewIndia, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBarIndia.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getActivity(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                        progressBarIndia.setVisibility(View.INVISIBLE);


                    }
                });
        return view;

    }
}
