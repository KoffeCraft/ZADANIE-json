package com.lusia.zadaniejson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholderAPI {
    @GET("db.json")
    public Call<List<Artykul>> getArtykuly();
}
