package com.arifur.weatherappusingkotlin.services

import com.arifur.weatherappusingkotlin.model.WeatherModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.QueryMap



/**
 * @author : Arif
 * @date : 1/2/2022-01-2022 7:00 PM
 * @package : com.arifur.weatherappusingkotlin.services
 * -------------------------------------------
 * Copyright (C) 2022 - All Rights Reserved
 **/
class Services {
    private val BASEURL: String = "https://api.openweathermap.org/"

    private val weatherApi: WeatherApi = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(WeatherApi::class.java)

    fun getWeatherData(appid:String, lat:String, lon:String): Single<WeatherModel> {
        return weatherApi.getCurrentWeather(appid = appid, lat = lat ,lon= lon)
    }

}