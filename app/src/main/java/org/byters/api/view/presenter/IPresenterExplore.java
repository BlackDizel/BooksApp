package org.byters.api.view.presenter;

import org.byters.api.view.presenter.listener.IPresenterMainListener;

public interface IPresenterExplore {
    void onClickLibrary();

    void setListener(IPresenterMainListener listener);

    void onCreateView();
}
