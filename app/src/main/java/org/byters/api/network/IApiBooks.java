package org.byters.api.network;

import org.byters.model.network.response.ResponseBookRequest;
import org.byters.model.network.response.ResponseBookSearch;
import org.byters.model.network.response.ResponseFeed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApiBooks {

    @GET("/feed")
    Call<ResponseFeed> requestFeed();

    @GET("/search_book")
    Call<ResponseBookSearch> searchBooks(@Query("query") String query);

    @GET("/book")
    Call<ResponseBookRequest> requestBook(@Query("title") String title,
                                          @Query("author") String author,
                                          @Query("isbn") String isbn);
}
