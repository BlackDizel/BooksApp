package org.byters.api.view.presenter;

public interface IPresenterFragmentBook {
    String getBookImage();

    String getBookTitle();

    String getBookAuthor();

    String getBookISBN();

    void onClickReserve();

    void onClickFavorite();

    void onClickReview();

    String getLibraryTitle(int position);

    String getLibraryBookAvailable(int position);

    int getItemsNum();

    int getItemsNumReviews();

    String getReviewAvatar(int position);

    String getReviewUsername(int position);

    String getReview(int position);
}
