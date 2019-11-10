package org.byters.booksapp.view.presenter;

import android.view.ViewGroup;

import org.byters.booksapp.view.presenter.listener.IPresenterAdapterExploreListener;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderBase;

public interface IPresenterAdapterExplore {
    ViewHolderBase onCreateViewHolder(ViewGroup viewGroup, int type);

    int getItemsNum();

    int getItemViewType(int position);

    void onSearch(String query);

    int getNewsNum();

    String getNewsImage(int position);

    String getNewsTitle(int position);

    int getCarouselBooksItemsNum(int carouselPosition);

    String getBookCover(int carouselPosition, int position);

    String getBookTitle(int carouselPosition, int position);

    void onClickBook(int carouselPosition, int adapterPosition);

    void onClickNews(int adapterPosition);

    String getCarouselTitle(int position);

    int getReviewsItemsNum();

    void onClickReview(int adapterPosition);

    String getReviewUsername(int position);

    String getReviewMessage(int position);

    String getReviewBook(int position);

    void setListener(IPresenterAdapterExploreListener listener);
}
