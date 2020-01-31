package org.byters.api.memorycache;

import org.byters.api.memorycache.listener.ICacheExploreListener;
import org.byters.model.ModelExplore;

public interface ICacheExplore {
    void addListener(ICacheExploreListener listener);

    int getNewsNum();

    String getNewsImage(int position);

    String getNewsTitle(int position);

    int getBooksNum(int carouselPosition);

    int getBlocksNum();

    String getBookCover(int carouselPosition, int position);

    String getBookTitle(int carouselPosition, int position);

    String getBookId(int carouselPosition, int adapterPosition);

    String getCarouselTitle(int position);

    int getReviewsNum();

    String getReviewUsername(int position);

    String getReviewMessage(int position);

    String getReviewBook(int position);

    void setData(ModelExplore data);

    int getType(int position);
}
