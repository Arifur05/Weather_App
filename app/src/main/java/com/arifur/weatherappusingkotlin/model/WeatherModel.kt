package com.arifur.weatherappusingkotlin.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.arifur.weatherappusingkotlin.model.Hourly
import com.arifur.weatherappusingkotlin.model.Daily
import com.arifur.weatherappusingkotlin.model.WeatherModel
import java.lang.StringBuilder

class WeatherModel {
    @SerializedName("lat")
    @Expose
    var lat: Double? = null

    @SerializedName("lon")
    @Expose
    var lon: Double? = null

    @SerializedName("timezone")
    @Expose
    var timezone: String? = null

    @SerializedName("timezone_offset")
    @Expose
    var timezoneOffset: Int? = null

    @SerializedName("current")
    @Expose
    var current: Current? = null

    @SerializedName("hourly")
    @Expose
    var hourly: List<Hourly>? = null

    @SerializedName("daily")
    @Expose
    var daily: List<Daily>? = null
    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(WeatherModel::class.java.name).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[')
        sb.append("lat")
        sb.append('=')
        sb.append(if (lat == null) "<null>" else lat)
        sb.append(',')
        sb.append("lon")
        sb.append('=')
        sb.append(if (lon == null) "<null>" else lon)
        sb.append(',')
        sb.append("timezone")
        sb.append('=')
        sb.append(if (timezone == null) "<null>" else timezone)
        sb.append(',')
        sb.append("timezoneOffset")
        sb.append('=')
        sb.append(if (timezoneOffset == null) "<null>" else timezoneOffset)
        sb.append(',')
        sb.append("current")
        sb.append('=')
        sb.append(if (current == null) "<null>" else current)
        sb.append(',')
        sb.append("hourly")
        sb.append('=')
        sb.append(if (hourly == null) "<null>" else hourly)
        sb.append(',')
        sb.append("daily")
        sb.append('=')
        sb.append(if (daily == null) "<null>" else daily)
        sb.append(',')
        if (sb[sb.length - 1] == ',') {
            sb.setCharAt(sb.length - 1, ']')
        } else {
            sb.append(']')
        }
        return sb.toString()
    }
}