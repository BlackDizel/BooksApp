package org.byters.booksapp.view.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.byters.booksapp.R;

public class FragmentBook extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        return view;
    }

    /*
    * register for unauth
    * rent book
    * in which libraries exist
    * when will be available
    * images
    * title, author, ISBN
    * synopsis
    * reviews
    * add to favorite
    * add review
    * */
}
