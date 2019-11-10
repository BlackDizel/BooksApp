package org.byters.booksapp.view.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.byters.booksapp.R;
import org.byters.booksapp.view.ui.adapter.AdapterBookRequest;
import org.byters.booksapp.view.ui.adapter.viewholder.util.SpacesItemDecoration;

public class FragmentBookRequest extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_request, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        RecyclerView rvItems = view.findViewById(R.id.rvBookSuggest);
        rvItems.setAdapter(new AdapterBookRequest());
        rvItems.addItemDecoration(new SpacesItemDecoration(view.getContext()));
    }
}
