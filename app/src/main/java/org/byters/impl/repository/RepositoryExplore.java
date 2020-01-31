package org.byters.impl.repository;

import org.byters.api.memorycache.ICacheExplore;
import org.byters.api.network.IApiBooks;
import org.byters.api.repository.IRepositoryExplore;
import org.byters.booksapp.BooksApplication;
import org.byters.model.network.response.ResponseFeed;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class RepositoryExplore implements IRepositoryExplore {

    private final RequestListener listener;

    @Inject
    ICacheExplore cacheExplore;

    @Inject
    IApiBooks api;

    public RepositoryExplore() {
        BooksApplication.getComponent().inject(this);
        listener = new RequestListener();
    }

    @Override
    public void request() {
        api.requestFeed().enqueue(listener);
    }

    private class RequestListener implements Callback<ResponseFeed> {

        @Override
        public void onResponse(Call<ResponseFeed> call, Response<ResponseFeed> response) {

            if (response.isSuccessful()) {
                cacheExplore.setData(response.body().getData());
            } else {
                cacheExplore.setData(null);
            }
        }

        @Override
        public void onFailure(Call<ResponseFeed> call, Throwable t) {
            if (call.isCanceled()) return;
            cacheExplore.setData(null);
        }
    }
}
