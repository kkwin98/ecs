package com.example.ecs.net;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HttpService {

    @GET("iris/RISUGetElecDocList.jsp")
    public Call<EcsDoc> getElecDocList(@Query("ecdwAdres") String ecdwAdres, @Query("DtFrom") String DtFrom, @Query("DtTo") String DtTo);

    @GET("iris/RISUGetEcdwAdres.jsp")
    public Call<Ecdw> getEcdwAdres(@Query("ecdwTy") String ecdwTy, @Query("enrNo") String enrNo);

    @GET("iris/RISUGetElecDocOpenUrl.jsp")
    public Call<EcsDocUrl> getElecDocOpenUrl(@Query("ecdwAdres") String ecdwAdres, @Query("docId") String docId);
}
