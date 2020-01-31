package org.byters.booksapp.view.ui.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import org.byters.api.view.ui.adapter.AdapterBase;
import org.byters.booksapp.BooksApplication;
import org.byters.api.view.presenter.IPresenterAdapterExplore;
import org.byters.api.view.presenter.listener.IPresenterAdapterExploreListener;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderBase;

import javax.inject.Inject;

public class AdapterExplore extends AdapterBase {

    private final IPresenterAdapterExploreListener listenerPresenter;
    @Inject
    IPresenterAdapterExplore presenter;

    public AdapterExplore() {
        BooksApplication.getComponent().inject(this);
        presenter.setListener(listenerPresenter = new ListenerPresenter());
    }

    @NonNull
    @Override
    public ViewHolderBase onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
        return presenter.onCreateViewHolder(viewGroup, type);
    }

    @Override
    public int getItemViewType(int position) {
        return presenter.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return presenter.getItemsNum();
    }

    private class ListenerPresenter implements IPresenterAdapterExploreListener {
        @Override
        public void onUpdate(){
            notifyDataSetChanged();
        }
    }

}
