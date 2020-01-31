package org.byters.impl.repository;

import org.byters.api.memorycache.ICacheBookSearch;
import org.byters.api.network.IApiBooks;
import org.byters.api.repository.IRepositoryBookSearch;
import org.byters.api.repository.listener.IRepositoryBookSearchListener;
import org.byters.booksapp.BooksApplication;
import org.byters.model.ModelBook;
import org.byters.model.network.response.ResponseBookSearch;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class RepositoryBookSearch implements IRepositoryBookSearch {

    private final RequestListener listenerRequest;

    @Inject
    ICacheBookSearch cacheBookSearch;

    @Inject
    IApiBooks api;

    private WeakReference<IRepositoryBookSearchListener> refListener;
    private Call<ResponseBookSearch> request;

    public RepositoryBookSearch() {
        BooksApplication.getComponent().inject(this);
        listenerRequest = new RequestListener();
    }

    @Override
    public void request(String query, IRepositoryBookSearchListener listener) {
        if (request != null)
            request.cancel();

        this.refListener = new WeakReference<>(listener);

        request = api.searchBooks(query);

        request.enqueue(listenerRequest);
    }

    private void notifyListeners(int booksNum, String first_book_id) {
        if (booksNum == 1)
            notifyListenersOne(first_book_id);
        else if (booksNum > 1)
            notifyListenersSeveral();
        else notifyListenersNone();
    }

    private void notifyListenersNone() {
        if (refListener == null || refListener.get() == null) return;
        refListener.get().onFindNone();

    }

    private void notifyListenersOne(String book_id) {
        if (refListener == null || refListener.get() == null) return;
        refListener.get().onFindOne(book_id);
    }

    private void notifyListenersSeveral() {
        if (refListener == null || refListener.get() == null) return;
        refListener.get().onFindSeveral();
    }

    private class RequestListener implements Callback<ResponseBookSearch> {

        @Override
        public void onResponse(Call<ResponseBookSearch> call, Response<ResponseBookSearch> response) {
            if (response.isSuccessful() && response.body() != null) {
                ArrayList<ModelBook> books = response.body().getBooks();
                cacheBookSearch.setBooks(books);

                notifyListeners(books == null ? 0 : books.size(), books == null || books.size() < 1 ? null : books.get(0).getId());
            } else notifyListenersNone();
        }

        @Override
        public void onFailure(Call<ResponseBookSearch> call, Throwable t) {
            if (call.isCanceled()) return;
            notifyListenersNone();
        }
    }

}
