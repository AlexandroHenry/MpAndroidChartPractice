package com.ret.mpandroidchartpractice

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "http://test.r-tong.com/"

    // OkHttpClient 생성 및 로깅 인터셉터 추가
    private val okHttpClient: OkHttpClient by lazy {
        val loggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                // 원하는 형식으로 로그 출력
                // 여기서는 간단하게 message를 출력하지만 JSON 형식으로 포맷팅 가능
                println(message)
            }
        }).apply {
            level = HttpLoggingInterceptor.Level.BODY // 로그 레벨 설정 (HEADERS, BASIC 등도 가능)
        }

        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient) // OkHttpClient 설정 추가
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}