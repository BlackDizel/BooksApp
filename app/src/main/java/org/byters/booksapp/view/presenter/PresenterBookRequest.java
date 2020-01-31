package org.byters.booksapp.view.presenter;

import org.byters.api.repository.IRepositoryBookRequest;
import org.byters.api.repository.listener.IRepositoryBookRequestListener;
import org.byters.api.view.INavigator;
import org.byters.api.view.presenter.IPresenterBookRequest;
import org.byters.api.view.ui.util.IHelperPopup;
import org.byters.booksapp.BooksApplication;
import org.byters.booksapp.R;

import javax.inject.Inject;

public class PresenterBookRequest implements IPresenterBookRequest {

    @Inject
    IRepositoryBookRequest repositoryBookRequest;

    @Inject
    IHelperPopup helperPopup;

    @Inject
    INavigator navigator;

    private BookRequestListener listenerBookRequest;

    public PresenterBookRequest() {
        BooksApplication.getComponent().inject(this);
    }

    @Override
    public void onClickRequest(String title, String author, String isbn) {
        repositoryBookRequest.request(title, author, isbn, listenerBookRequest);
    }

    private class BookRequestListener implements IRepositoryBookRequestListener {
        @Override
        public void onSuccess(){
            navigator.navigateExplore();
        }

        @Override
        public void onFail(){
            helperPopup.showMessage(R.string.booK_request_fail);
        }
    }
}
