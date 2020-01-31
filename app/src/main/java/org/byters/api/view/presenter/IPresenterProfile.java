package org.byters.api.view.presenter;

import org.byters.booksapp.view.ui.adapter.listener.IAdapterBookInRentListener;
import org.byters.booksapp.view.ui.adapter.listener.IAdapterBookListener;

public interface IPresenterProfile {
    String getUsername();

    String getBio();

    String getAvatar();

    int getReviewsNum();

    String getReviewMessage(int position);

    String getReviewBook(int position);

    void onClickReview(int adapterPosition);

    IAdapterBookListener getListenerFavorite();

    IAdapterBookInRentListener getListenerBooksInRent();
}
