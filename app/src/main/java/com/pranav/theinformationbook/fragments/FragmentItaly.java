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

public class FragmentItaly extends Fragment {


    public static FragmentItaly newInstance(){
        return new FragmentItaly();
    }
    private ImageView imageViewItaly;
    private ProgressBar progressBarItaly;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //using inflater object we will define our design
        //ViewGroup represents the activity to which well bind our activity
        //bundle states whether we can create it from any situation we saved before

        View view = inflater.inflate(R.layout.fragment_italy, container,false);

        imageViewItaly = view.findViewById(R.id.imageViewItaly);
        progressBarItaly = view.findViewById(R.id.progressBarItaly);
        //we need to create an instance from this class using which well be able to use our instance in the view page adapter

        //using picasso we can load the images from the web using their image address
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/0/03/" +
                        "Flag_of_Italy.svg/188px-Flag_of_Italy.svg.png")
                .into(imageViewItaly, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBarItaly.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getActivity(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                        progressBarItaly.setVisibility(View.INVISIBLE);


                    }
                });
        return view;

    }
}
