package org.byters.booksapp.view.presenter;

public interface IPresenterAdapterBookSuggest {
    int getItemsNum();

    String getBookTitle(int position);

    String getImage(int position);

    String getBookStore(int position);

    String getBookPrice(int position);

    void onClickBook(int adapterPosition);
}
