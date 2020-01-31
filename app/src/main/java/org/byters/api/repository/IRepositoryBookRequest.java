package org.byters.api.repository;

import org.byters.api.repository.listener.IRepositoryBookRequestListener;

public interface IRepositoryBookRequest {
    void request(String title, String author, String isbn, IRepositoryBookRequestListener listener);
}
