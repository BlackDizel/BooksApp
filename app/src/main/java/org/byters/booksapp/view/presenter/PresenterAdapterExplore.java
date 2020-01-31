package org.byters.booksapp.view.presenter;

import android.view.ViewGroup;

import org.byters.api.repository.IRepositoryBookSearch;
import org.byters.api.repository.listener.IRepositoryBookSearchListener;
import org.byters.api.view.presenter.IPresenterAdapterExplore;
import org.byters.booksapp.BooksApplication;
import org.byters.api.view.INavigator;
import org.byters.booksapp.R;
import org.byters.api.memorycache.ICacheExplore;
import org.byters.api.memorycache.listener.ICacheExploreListener;
import org.byters.model.ExploreItemEnum;
import org.byters.api.view.presenter.listener.IPresenterAdapterExploreListener;
import org.byters.booksapp.view.ui.adapter.AdapterExploreNews;
import org.byters.booksapp.view.ui.adapter.AdapterExploreReviewsCarousel;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderBase;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderExploreCarouselBase;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderExploreCarouselBooks;
import org.byters.booksapp.view.ui.adapter.viewholder.ViewHolderExploreSearch;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

public class PresenterAdapterExplore implements IPresenterAdapterExplore {

    private final ICacheExploreListener listenerCacheExplore;
    private final SearchListener listenerSearch;

    @Inject
    INavigator navigator;

    @Inject
    ICacheExplore cacheExplore;

    @Inject
    IRepositoryBookSearch repositoryBookSearch;

    private WeakReference<IPresenterAdapterExploreListener> refListener;

    public PresenterAdapterExplore() {
        BooksApplication.getComponent().inject(this);
        cacheExplore.addListener(listenerCacheExplore = new ListenerCacheExplore());
        listenerSearch = new SearchListener();
    }

    @Override
    public ViewHolderBase onCreateViewHolder(ViewGroup viewGroup, int type) {

        if (type == ExploreItemEnum.TYPE_NEWS.getValue())
            return new ViewHolderExploreCarouselBase(viewGroup, R.string.empty, new AdapterExploreNews());

        if (type == ExploreItemEnum.TYPE_SEARCH.getValue())
            return new ViewHolderExploreSearch(viewGroup);

        if (type == ExploreItemEnum.TYPE_BLOCK.getValue())
            return new ViewHolderExploreCarouselBooks(viewGroup);

        if (type == ExploreItemEnum.TYPE_REVIEWS.getValue())
            return new ViewHolderExploreCarouselBase(viewGroup, R.string.title_reviews, new AdapterExploreReviewsCarousel());


        return null;
    }

    @Override
    public int getItemsNum() {
        return cacheExplore.getBlocksNum();
    }

    @Override
    public int getItemViewType(int position) {
        return cacheExplore.getType(position);
    }

    @Override
    public void onSearch(String query) {
        repositoryBookSearch.request(query, listenerSearch);
    }

    @Override
    public int getNewsNum() {
        return cacheExplore.getNewsNum();
    }

    @Override
    public String getNewsImage(int position) {
        return cacheExplore.getNewsImage(position);
    }

    @Override
    public String getNewsTitle(int position) {
        return cacheExplore.getNewsTitle(position);
    }

    @Override
    public int getCarouselBooksItemsNum(int carouselPosition) {
        return cacheExplore.getBooksNum(carouselPosition);
    }

    @Override
    public String getBookCover(int carouselPosition, int position) {
        return cacheExplore.getBookCover(carouselPosition, position);
    }

    @Override
    public String getBookTitle(int carouselPosition, int position) {
        return cacheExplore.getBookTitle(carouselPosition, position);
    }

    @Override
    public void onClickBook(int carouselPosition, int adapterPosition) {
        navigator.navigateBook(cacheExplore.getBookId(carouselPosition,adapterPosition));
    }

    @Override
    public void onClickNews(int adapterPosition) {
        //todo implement
    }

    @Override
    public String getCarouselTitle(int position) {
        return cacheExplore.getCarouselTitle(position);
    }

    @Override
    public int getReviewsItemsNum() {
        return cacheExplore.getReviewsNum();
    }

    @Override
    public void onClickReview(int adapterPosition) {
        //todo implement
    }

    @Override
    public String getReviewUsername(int position) {
        return cacheExplore.getReviewUsername(position);
    }

    @Override
    public String getReviewMessage(int position) {
        return cacheExplore.getReviewMessage(position);
    }

    @Override
    public String getReviewBook(int position) {
        return cacheExplore.getReviewBook(position);
    }

    @Override
    public void setListener(IPresenterAdapterExploreListener listener) {
        this.refListener = new WeakReference<>(listener);
    }

    private class ListenerCacheExplore implements ICacheExploreListener {
        @Override
        public void onUpdate() {
            if (refListener == null || refListener.get() == null) return;
            refListener.get().onUpdate();
        }
    }

    private class SearchListener implements IRepositoryBookSearchListener {

        @Override
        public void onFindOne(String book_id){
            navigator.navigateBook(book_id);
        }

        @Override
        public void onFindSeveral(){
            navigator.navigateBookSearchResult();
        }

        @Override
        public void onFindNone(){
            navigator.navigateBookRequest();
        }
    }
}
