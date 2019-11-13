package org.byters.booksapp.view.ui.adapter.listener;

public interface IAdapterBookListener {
    int getItemsNum();

    void onClickItem(int adapterPosition);

    String getTitle(int position);

    String getCover(int position);
}
