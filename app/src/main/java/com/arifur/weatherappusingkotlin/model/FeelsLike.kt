package com.arifur.weatherappusingkotlin.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.arifur.weatherappusingkotlin.model.FeelsLike
import java.lang.StringBuilder

class FeelsLike {
    @SerializedName("day")
    @Expose
    var day: Double? = null

    @SerializedName("night")
    @Expose
    var night: Double? = null

    @SerializedName("eve")
    @Expose
    var eve: Double? = null

    @SerializedName("morn")
    @Expose
    var morn: Double? = null
    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(FeelsLike::class.java.name).append('@')
            .append(Integer.toHexString(System.identityHashCode(this))).append('[')
        sb.append("day")
        sb.append('=')
        sb.append(if (day == null) "<null>" else day)
        sb.append(',')
        sb.append("night")
        sb.append('=')
        sb.append(if (night == null) "<null>" else night)
        sb.append(',')
        sb.append("eve")
        sb.append('=')
        sb.append(if (eve == null) "<null>" else eve)
        sb.append(',')
        sb.append("morn")
        sb.append('=')
        sb.append(if (morn == null) "<null>" else morn)
        sb.append(',')
        if (sb[sb.length - 1] == ',') {
            sb.setCharAt(sb.length - 1, ']')
        } else {
            sb.append(']')
        }
        return sb.toString()
    }
}