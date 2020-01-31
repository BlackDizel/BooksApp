package org.byters.api.network;

import org.byters.model.network.response.ResponseBookSearch;
import org.byters.model.network.response.ResponseFeed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApiBooks {
    @GET
    Call<ResponseFeed> requestFeed();

    @GET
    Call<ResponseBookSearch> searchBooks(@Query("query") String query);
}
