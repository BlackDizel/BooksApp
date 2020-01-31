package org.byters.impl.repository;

import org.byters.api.network.IApiBooks;
import org.byters.api.repository.IRepositoryBookRequest;
import org.byters.api.repository.listener.IRepositoryBookRequestListener;
import org.byters.booksapp.BooksApplication;
import org.byters.model.network.response.ResponseBookRequest;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryBookRequest implements IRepositoryBookRequest {

    private final RequestListener listenerRequest;

    @Inject
    IApiBooks api;

    private WeakReference<IRepositoryBookRequestListener> refListener;

    public RepositoryBookRequest() {
        BooksApplication.getComponent().inject(this);
        listenerRequest = new RequestListener();
    }

    @Override
    public void request(String title, String author, String isbn, IRepositoryBookRequestListener listener) {
        this.refListener = new WeakReference<>(listener);
        api.requestBook(title, author, isbn).enqueue(listenerRequest);
    }

    private void notifyListenerSuccess() {
        if (refListener == null || refListener.get() == null) return;
        refListener.get().onSuccess();
    }

    private void notifyListenerFail() {
        if (refListener == null || refListener.get() == null) return;
        refListener.get().onFail();
    }

    private class RequestListener implements Callback<ResponseBookRequest> {

        @Override
        public void onResponse(Call<ResponseBookRequest> call, Response<ResponseBookRequest> response) {
            if (response.isSuccessful())
                notifyListenerSuccess();
            else notifyListenerFail();
        }

        @Override
        public void onFailure(Call<ResponseBookRequest> call, Throwable t) {
            if (call.isCanceled()) return;
            notifyListenerFail();
        }
    }
}
