package org.byters.api.repository.listener;

public interface IRepositoryBookSearchListener {
    void onFindOne(String book_id);

    void onFindSeveral();

    void onFindNone();
}
