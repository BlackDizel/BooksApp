package org.byters.booksapp.view.presenter;

import org.byters.booksapp.view.presenter.listener.IPresenterMainListener;

public interface IPresenterExplore {
    void onClickLibrary();

    void setListener(IPresenterMainListener listener);

    void onCreateView();
}
