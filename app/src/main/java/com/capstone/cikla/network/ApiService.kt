package com.capstone.cikla.network

import com.capstone.cikla.user.User
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {



    //private  val URL_BASE = "https://us-central1-mkt-003001-00813.cloudfunctions.net/"

    companion object {
        private const val URL_BASE = "http://192.168.1.4:8080/api/"
    }

    fun getRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder().addInterceptor(logging).build()

        return Retrofit.Builder()
            .baseUrl(URL_BASE)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val httpClient = OkHttpClient.Builder().addInterceptor(logging).build()





    /*fun getUsers(): Single<List<User>> {
        return retrofit2.getUsers()
    }*/

    /*fun getLink(): Single<Enlace.optionLink> {
        return retrofit2.enlaces()
    }*/

}