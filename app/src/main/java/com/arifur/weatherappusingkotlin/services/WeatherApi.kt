package com.arifur.weatherappusingkotlin.services

import com.arifur.weatherappusingkotlin.model.WeatherModel
import io.reactivex.Single
import retrofit2.http.GET

import retrofit2.http.QueryMap

/**
 * @author : Arif
 * @date : 1/2/2022-01-2022 6:59 PM
 * @package : com.arifur.weatherappusingkotlin.services
 * -------------------------------------------
 * Copyright (C) 2022 - All Rights Reserved
 **/
interface WeatherApi {
   // lat=23.72&lon=90.41
//    &appid=05f97c207bd8e3f4ed8cbeb774646919
    @GET("2.5/onecall?&exclude=minutely&units=metric")
    fun  getCurrentWeather(@QueryMap queries: QueryMap,
                           ): Single<WeatherModel>
}
//@Query("uid") uid: String,