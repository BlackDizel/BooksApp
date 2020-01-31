package org.byters.api.network;

import org.byters.model.network.response.ResponseFeed;

public interface IApiBooks {
    @GET
    Call<ResponseFeed> requestFeed();

}
