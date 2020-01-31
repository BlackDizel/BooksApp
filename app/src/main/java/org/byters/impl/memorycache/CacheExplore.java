package org.byters.impl.memorycache;

import org.byters.api.memorycache.ICacheExplore;
import org.byters.api.memorycache.listener.ICacheExploreListener;
import org.byters.model.ExploreItemEnum;
import org.byters.model.ModelExplore;

import java.lang.ref.WeakReference;

public class CacheExplore implements ICacheExplore {
    private WeakReference<ICacheExploreListener> refListener;
    private ModelExplore data;

    @Override
    public void addListener(ICacheExploreListener listener) {
        this.refListener = new WeakReference<>(listener);
    }

    @Override
    public int getNewsNum() {
        return data == null ? 0 : data.newsSize();
    }

    @Override
    public String getNewsImage(int position) {
        return data == null ? "" : data.newsImage(position);
    }

    @Override
    public String getNewsTitle(int position) {
        return data == null ? "" : data.newsTitle(position);
    }

    @Override
    public int getBooksNum(int carouselPosition) {
        return data == null ? 0 : data.blockItemsNum(carouselPosition);
    }

    @Override
    public int getBlocksNum() {
        return data == null ? 0 : data.size();
    }

    @Override
    public String getBookCover(int carouselPosition, int position) {
        return data == null ? "" : data.blockItemImage(carouselPosition, position);
    }

    @Override
    public String getBookTitle(int carouselPosition, int position) {
        return data == null ? "" : data.blockItemTitle(carouselPosition, position);
    }

    @Override
    public String getCarouselTitle(int position) {
        return data == null ? "" : data.blockTitle(position);
    }

    @Override
    public int getReviewsNum() {
        return data == null ? 0 : data.reviewsNum();
    }

    @Override
    public String getReviewUsername(int position) {
        return data == null ? "" : data.reviewUsername(position);
    }

    @Override
    public String getReviewMessage(int position) {
        return data == null ? "" : data.reviewMessage(position);
    }

    @Override
    public String getReviewBook(int position) {
        return data == null ? "" : data.reviewBook(position);
    }

    @Override
    public void setData(ModelExplore data) {
        this.data = data;
        notifyListeners();
    }

    @Override
    public int getType(int position) {
        return data == null ? ExploreItemEnum.TYPE_UNKNOWN.getValue() : data.getType(position);
    }

    private void notifyListeners() {
        if (refListener == null || refListener.get() == null) return;
        refListener.get().onUpdate();
    }
}
