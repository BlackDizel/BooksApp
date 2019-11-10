package org.byters.booksapp.view.ui.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import org.byters.booksapp.BooksApplication;
import org.byters.booksapp.view.presenter.IPresenterAdapterExplore;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderBase;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderReview;

import javax.inject.Inject;

public class AdapterExploreReviewsCarousel extends AdapterBase {

    @Inject
    IPresenterAdapterExplore presenter;

    public AdapterExploreReviewsCarousel() {
        BooksApplication.getComponent().inject(this);
    }

    @NonNull
    @Override
    public ViewHolderBase onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolderReview(viewGroup);
    }

    @Override
    public int getItemCount() {
        return presenter.getReviewsItemsNum();
    }
}
