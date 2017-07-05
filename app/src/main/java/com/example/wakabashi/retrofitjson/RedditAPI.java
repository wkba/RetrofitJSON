package com.example.wakabashi.retrofitjson;

import com.example.wakabashi.retrofitjson.model.Feed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by wakabashi on 2017/07/04.
 */

public interface RedditAPI {

    String BASE_USL = "https://www.reddit.com/";

    @Headers("Content-Type: application/json")
    @GET(".json")
    Call<Feed> getData();
}
