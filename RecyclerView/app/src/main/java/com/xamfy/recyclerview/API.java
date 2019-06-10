package com.xamfy.recyclerview;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class API {
    private static final String url = "https://my-json-server.typicode.com/xamfy/android-resources/";

    public static ImageService sImageService = null;

    public static ImageService getService() {
        if (sImageService == null) {
            Retrofit retrofit = new Retrofit.Builder().
                    baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            sImageService = retrofit.create(ImageService.class);
        }

        return sImageService;
    }

    public interface ImageService {
        @GET("images/")
        Call<List<ImageList>> getImageList();
    }
}
