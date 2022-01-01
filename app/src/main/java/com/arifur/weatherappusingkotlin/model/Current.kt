package com.arifur.weatherappusingkotlin.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.arifur.weatherappusingkotlin.model.Weather
import java.lang.StringBuilder

class Current {
    @SerializedName("dt")
    @Expose
    var dt: Int? = null

    @SerializedName("sunrise")
    @Expose
    var sunrise: Int? = null

    @SerializedName("sunset")
    @Expose
    var sunset: Int? = null

    @SerializedName("temp")
    @Expose
    var temp: Double? = null

    @SerializedName("feels_like")
    @Expose
    var feelsLike: Double? = null

    @SerializedName("pressure")
    @Expose
    var pressure: Int? = null

    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null

    @SerializedName("dew_point")
    @Expose
    var dewPoint: Double? = null

    @SerializedName("uvi")
    @Expose
    var uvi: Int? = null

    @SerializedName("clouds")
    @Expose
    var clouds: Int? = null

    @SerializedName("visibility")
    @Expose
    var visibility: Int? = null

    @SerializedName("wind_speed")
    @Expose
    var windSpeed: Double? = null

    @SerializedName("wind_deg")
    @Expose
    var windDeg: Int? = null

    @SerializedName("weather")
    @Expose
    var weather: List<Weather>? = null
    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(Current::class.java.name).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[')
        sb.append("dt")
        sb.append('=')
        sb.append(if (dt == null) "<null>" else dt)
        sb.append(',')
        sb.append("sunrise")
        sb.append('=')
        sb.append(if (sunrise == null) "<null>" else sunrise)
        sb.append(',')
        sb.append("sunset")
        sb.append('=')
        sb.append(if (sunset == null) "<null>" else sunset)
        sb.append(',')
        sb.append("temp")
        sb.append('=')
        sb.append(if (temp == null) "<null>" else temp)
        sb.append(',')
        sb.append("feelsLike")
        sb.append('=')
        sb.append(if (feelsLike == null) "<null>" else feelsLike)
        sb.append(',')
        sb.append("pressure")
        sb.append('=')
        sb.append(if (pressure == null) "<null>" else pressure)
        sb.append(',')
        sb.append("humidity")
        sb.append('=')
        sb.append(if (humidity == null) "<null>" else humidity)
        sb.append(',')
        sb.append("dewPoint")
        sb.append('=')
        sb.append(if (dewPoint == null) "<null>" else dewPoint)
        sb.append(',')
        sb.append("uvi")
        sb.append('=')
        sb.append(if (uvi == null) "<null>" else uvi)
        sb.append(',')
        sb.append("clouds")
        sb.append('=')
        sb.append(if (clouds == null) "<null>" else clouds)
        sb.append(',')
        sb.append("visibility")
        sb.append('=')
        sb.append(if (visibility == null) "<null>" else visibility)
        sb.append(',')
        sb.append("windSpeed")
        sb.append('=')
        sb.append(if (windSpeed == null) "<null>" else windSpeed)
        sb.append(',')
        sb.append("windDeg")
        sb.append('=')
        sb.append(if (windDeg == null) "<null>" else windDeg)
        sb.append(',')
        sb.append("weather")
        sb.append('=')
        sb.append(if (weather == null) "<null>" else weather)
        sb.append(',')
        if (sb[sb.length - 1] == ',') {
            sb.setCharAt(sb.length - 1, ']')
        } else {
            sb.append(']')
        }
        return sb.toString()
    }
}