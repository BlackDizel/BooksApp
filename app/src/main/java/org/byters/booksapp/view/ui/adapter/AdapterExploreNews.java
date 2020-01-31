package org.byters.booksapp.view.ui.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import org.byters.api.view.ui.adapter.AdapterBase;
import org.byters.booksapp.BooksApplication;
import org.byters.api.view.presenter.IPresenterAdapterExplore;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderBase;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderNews;

import javax.inject.Inject;

public class AdapterExploreNews extends AdapterBase {

    @Inject
    IPresenterAdapterExplore presenter;

    public AdapterExploreNews() {
        BooksApplication.getComponent().inject(this);
    }

    @NonNull
    @Override
    public ViewHolderBase onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolderNews(viewGroup);
    }

    @Override
    public int getItemCount() {
        return presenter.getNewsNum();
    }
}
