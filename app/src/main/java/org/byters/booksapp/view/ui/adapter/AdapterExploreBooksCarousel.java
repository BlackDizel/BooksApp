package org.byters.booksapp.view.ui.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import org.byters.api.view.ui.adapter.AdapterBase;
import org.byters.booksapp.BooksApplication;
import org.byters.api.view.presenter.IPresenterAdapterExplore;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderBase;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderBook;

import javax.inject.Inject;

public class AdapterExploreBooksCarousel extends AdapterBase {

    @Inject
    IPresenterAdapterExplore presenter;

    private int carouselPosition;

    public AdapterExploreBooksCarousel() {
        BooksApplication.getComponent().inject(this);
    }

    @NonNull
    @Override
    public ViewHolderBase onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolderBook(viewGroup, carouselPosition);
    }

    @Override
    public int getItemCount() {
        return presenter.getCarouselBooksItemsNum(carouselPosition);
    }

    public void setPosition(int position) {
        this.carouselPosition = position;
    }
}
