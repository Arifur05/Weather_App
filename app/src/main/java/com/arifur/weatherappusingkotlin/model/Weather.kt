package com.arifur.weatherappusingkotlin.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.arifur.weatherappusingkotlin.model.Weather
import java.lang.StringBuilder

class Weather {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("main")
    @Expose
    var main: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("icon")
    @Expose
    var icon: String? = null
    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(Weather::class.java.name).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[')
        sb.append("id")
        sb.append('=')
        sb.append(if (id == null) "<null>" else id)
        sb.append(',')
        sb.append("main")
        sb.append('=')
        sb.append(if (main == null) "<null>" else main)
        sb.append(',')
        sb.append("description")
        sb.append('=')
        sb.append(if (description == null) "<null>" else description)
        sb.append(',')
        sb.append("icon")
        sb.append('=')
        sb.append(if (icon == null) "<null>" else icon)
        sb.append(',')
        if (sb[sb.length - 1] == ',') {
            sb.setCharAt(sb.length - 1, ']')
        } else {
            sb.append(']')
        }
        return sb.toString()
    }
}