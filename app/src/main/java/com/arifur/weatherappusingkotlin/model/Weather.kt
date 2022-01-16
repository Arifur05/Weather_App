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

}