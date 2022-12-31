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

public class FragmentTajMahal extends Fragment {


    public static FragmentTajMahal newInstance(){
        return new FragmentTajMahal();
    }
    private ImageView imageViewTajMahal;
    private ProgressBar progressBarTajMahal;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //using inflater object we will define our design
        //ViewGroup represents the activity to which well bind our activity
        //bundle states whether we can create it from any situation we saved before

        View view = inflater.inflate(R.layout.fragment_taj_mahal, container,false);

        imageViewTajMahal = view.findViewById(R.id.imageViewTajMahal);
        progressBarTajMahal = view.findViewById(R.id.progressBarTajMahal);
        //we need to create an instance from this class using which well be able to use our instance in the view page adapter

        //using picasso we can load the images from the web using their image address
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Taj_Mahal" +
                        "_in_India_-_Kristian_Bertel.jpg/375px-Taj_Mahal_in_India_-_Kristian_Bertel.jpg")
                .into(imageViewTajMahal, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBarTajMahal.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getActivity(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                        progressBarTajMahal.setVisibility(View.INVISIBLE);


                    }
                });
        return view;

    }
}
