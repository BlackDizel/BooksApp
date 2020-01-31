package org.byters.api.repository;

import org.byters.api.repository.listener.IRepositoryBookSearchListener;

public interface IRepositoryBookSearch {
    void request(String query, IRepositoryBookSearchListener listener);
}
