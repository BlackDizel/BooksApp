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

import org.byters.booksapp.BooksApplication;
import org.byters.booksapp.R;
import org.byters.booksapp.view.presenter.IPresenterFragmentBook;
import org.byters.booksapp.view.ui.adapter.AdapterBookLibrary;
import org.byters.booksapp.view.ui.adapter.AdapterBookReview;
import org.byters.booksapp.view.ui.adapter.viewholder.util.SpacesItemDecoration;

import javax.inject.Inject;

public class FragmentBook extends Fragment implements View.OnClickListener {

    @Inject
    IPresenterFragmentBook presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BooksApplication.getComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {

        ImageView ivBook = view.findViewById(R.id.ivBook);
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvAuthor = view.findViewById(R.id.tvAuthor);
        TextView tvISBN = view.findViewById(R.id.tvISBN);

        view.findViewById(R.id.ivReserve).setOnClickListener(this);
        view.findViewById(R.id.ivFavorite).setOnClickListener(this);
        view.findViewById(R.id.ivReview).setOnClickListener(this);

        RecyclerView rvBookLibrary = view.findViewById(R.id.rvBookLibrary);
        rvBookLibrary.setAdapter(new AdapterBookLibrary());

        RecyclerView rvBookReview = view.findViewById(R.id.rvBookReviews);
        rvBookReview.setAdapter(new AdapterBookReview());
        rvBookReview.addItemDecoration(new SpacesItemDecoration(view.getContext()));

        Glide.with(view.getContext())
                .load(presenter.getBookImage())
                .into(ivBook);

        tvTitle.setText(presenter.getBookTitle());
        tvAuthor.setText(presenter.getBookAuthor());
        tvISBN.setText(presenter.getBookISBN());

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ivReserve)
            presenter.onClickReserve();

        if (view.getId() == R.id.ivFavorite)
            presenter.onClickFavorite();

        if (view.getId() == R.id.ivReview)
            presenter.onClickReview();
    }

    /*
     * register for unauth
     * when will be available
     * book prices
     * book reviews from other websites
     * on click author open fragment book list with his books
     * book quotes
     */
}
