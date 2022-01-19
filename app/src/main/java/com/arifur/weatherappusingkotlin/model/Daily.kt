package com.arifur.weatherappusingkotlin.model

import com.arifur.weatherappusingkotlin.model.FeelsLike
import com.arifur.weatherappusingkotlin.model.Weather
import com.arifur.weatherappusingkotlin.model.Temp
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose


class Daily {
    @SerializedName("dt")
    @Expose
    var dt: Int? = null

    @SerializedName("sunrise")
    @Expose
    var sunrise: Int? = null

    @SerializedName("sunset")
    @Expose
    var sunset: Int? = null

    @SerializedName("moonrise")
    @Expose
    var moonrise: Int? = null

    @SerializedName("moonset")
    @Expose
    var moonset: Int? = null

    @SerializedName("moon_phase")
    @Expose
    var moonPhase: Double? = null

    @SerializedName("temp")
    @Expose
    var temp: Temp? = null

    @SerializedName("feels_like")
    @Expose
    var feelsLike: FeelsLike? = null

    @SerializedName("pressure")
    @Expose
    var pressure: Int? = null

    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null

    @SerializedName("dew_point")
    @Expose
    var dewPoint: Double? = null

    @SerializedName("wind_speed")
    @Expose
    var windSpeed: Double? = null

    @SerializedName("wind_deg")
    @Expose
    var windDeg: Int? = null

    @SerializedName("wind_gust")
    @Expose
    var windGust: Double? = null

    @SerializedName("weather")
    @Expose
    var weather: List<Weather>? = null

    @SerializedName("clouds")
    @Expose
    var clouds: Int? = null

    @SerializedName("pop")
    @Expose
    var pop: Int? = null

    @SerializedName("uvi")
    @Expose
    var uvi: Double? = null

}