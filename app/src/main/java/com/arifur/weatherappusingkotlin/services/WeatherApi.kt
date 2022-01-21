package com.arifur.weatherappusingkotlin.services

import com.arifur.weatherappusingkotlin.model.WeatherModel

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

import retrofit2.http.QueryMap

/**
 * @author : Arif
 * @date : 1/2/2022-01-2022 6:59 PM
 * @package : com.arifur.weatherappusingkotlin.services
 * -------------------------------------------
 * Copyright (C) 2022 - All Rights Reserved
 **/
interface WeatherApi {

    @GET("data/2.5/onecall?&exclude=minutely&units=metric")
    fun  getCurrentWeather(@Query("appid") appid: String,
                           @Query("lat") lat: String,
                           @Query("lon") lon: String,
                           ): Single<WeatherModel>



}
