package org.byters.booksapp.view.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.byters.booksapp.BooksApplication;
import org.byters.booksapp.R;
import org.byters.booksapp.view.ui.adapter.AdapterBookFavorite;
import org.byters.api.view.presenter.IPresenterProfile;
import org.byters.booksapp.view.ui.adapter.AdapterBookInRent;
import org.byters.booksapp.view.ui.adapter.AdapterProfileBooksReviews;
import org.byters.booksapp.view.ui.adapter.viewholder.util.SpacesItemDecoration;

import javax.inject.Inject;

public class FragmentProfile extends Fragment implements View.OnClickListener {

    @Inject
    IPresenterProfile presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BooksApplication.getComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        initViews(view);
        return view;
    }

    private void initViews(View view) {
        ImageView ivAvatar = view.findViewById(R.id.ivAvatar);
        TextView tvUsername = view.findViewById(R.id.tvUsername);
        TextView tvBio = view.findViewById(R.id.tvBio);
        RecyclerView rvBooksFavorite = view.findViewById(R.id.rvBooksFavorite);
        RecyclerView rvBooksInRent = view.findViewById(R.id.rvBooksInRent);
        RecyclerView rvReviews = view.findViewById(R.id.rvBookReviews);

        view.findViewById(R.id.ivLogout).setOnClickListener(this);

        rvBooksFavorite.setAdapter(new AdapterBookFavorite(presenter.getListenerFavorite()));
        rvBooksInRent.setAdapter(new AdapterBookInRent(presenter.getListenerBooksInRent()));
        rvReviews.setAdapter(new AdapterProfileBooksReviews());

        rvBooksFavorite.addItemDecoration(new SpacesItemDecoration(view.getContext()));
        rvBooksInRent.addItemDecoration(new SpacesItemDecoration(view.getContext()));

        tvUsername.setText(presenter.getUsername());
        tvBio.setText(presenter.getBio());

        Glide.with(view.getContext())
                .load(presenter.getAvatar())
                .apply(RequestOptions.circleCropTransform())
                .into(ivAvatar);
    }

    @Override
    public void onClick(View view) {
        //todo
    }


}
