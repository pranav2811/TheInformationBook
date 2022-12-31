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

public class FragmentFrance extends Fragment {


    public static FragmentFrance newInstance(){
        return new FragmentFrance();
    }
    private ImageView imageViewFrance;
    private ProgressBar progressBarFrance;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //using inflater object we will define our design
        //ViewGroup represents the activity to which well bind our activity
        //bundle states whether we can create it from any situation we saved before

        View view = inflater.inflate(R.layout.fragment_france, container,false);

        imageViewFrance = view.findViewById(R.id.imageViewFrance);
        progressBarFrance = view.findViewById(R.id.progressBarFrance);
        //we need to create an instance from this class using which well be able to use our instance in the view page adapter

        //using picasso we can load the images from the web using their image address
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France" +
                        ".svg/188px-Flag_of_France.svg.png")
                .into(imageViewFrance, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBarFrance.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getActivity(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                        progressBarFrance.setVisibility(View.INVISIBLE);


                    }
                });
        return view;

    }
}
