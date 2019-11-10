package org.byters.booksapp.view.presenter;

import org.byters.booksapp.BooksApplication;
import org.byters.booksapp.repository.IRepositoryExplore;
import org.byters.booksapp.view.presenter.listener.IPresenterMainListener;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

public class PresenterExplore implements IPresenterExplore {

    @Inject
    IRepositoryExplore repositoryExplore;

    private WeakReference<IPresenterMainListener> refListener;

    public PresenterExplore() {
        BooksApplication.getComponent().inject(this);
    }

    @Override
    public void onClickLibrary() {
        //todo implement
    }

    @Override
    public void setListener(IPresenterMainListener listener) {
        this.refListener = new WeakReference<>(listener);
    }

    @Override
    public void onCreateView() {
        repositoryExplore.request();
    }
}
