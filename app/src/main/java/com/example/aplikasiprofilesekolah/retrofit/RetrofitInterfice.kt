package com.example.aplikasiprofilesekolah.retrofit

import com.example.aplikasiprofilesekolah.model.ItemRV
import retrofit2.Response
import retrofit2.http.GET

// untuk menampil kan data lengkap dari url
interface RetrofitInterfice {
    // suspend fun digunakan untuk membuat fungsi yang berjalan Asynchronous

    @GET("data/ekskul.json")
    suspend fun getDataEkskul(): Response<List<ItemRV>>

    @GET("data/galeri.json")
    suspend fun getDataGaleri(): Response<List<ItemRV>>

    @GET("data/Prestasi.json")
    suspend fun getDataPrestasi(): Response<List<ItemRV>>

}