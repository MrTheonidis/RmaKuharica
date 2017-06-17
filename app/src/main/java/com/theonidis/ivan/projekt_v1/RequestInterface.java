package com.theonidis.ivan.projekt_v1;

/**
 * Created by Ivan on 5.6.2017..
 */

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("bins/10u3bb")
    Call<JSONResponse> getJSON();
}
