package com.example.aplikasiprofilesekolah.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitService {
    // fungsi HttpLoggingInterceptor adalah mengecek status response dari server
    // keterangan status server di LogCat :
    // 200 = respose sukses
    // 404 = url not found
    // 401 = tidak ada otorisasi / API Key belum dimasukkan
    // 500 = Masalah di server
//    private fun interceptor(): Interceptor {
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.level = HttpLoggingInterceptor.Level.BASIC
//        return interceptor
//    }

    // client bertugas sebagai alat penghubung ke server
    // di sini tempat kita memasukkan Interceptor
    private val client = OkHttpClient.Builder()
//        .addInterceptor(interceptor())
        .build()

    // retrofit bertugas sebagai pengatur client
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://profile-sekolah-41e38.firebaseio.com/") // masukkan baseUrl sesuai server
        .addConverterFactory(MoshiConverterFactory.create())//masukan alamat menggunakan moshi
        .client(client)// masukan client yang di gunakan
        .build()

    fun <T> buildService(service: Class<T>): T {// digunakan membuat service esuai interface retrofit
        return retrofit.create(service)
    }
}