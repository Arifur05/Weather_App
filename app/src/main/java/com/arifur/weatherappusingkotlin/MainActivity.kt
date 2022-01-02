package com.arifur.weatherappusingkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.arifur.weatherappusingkotlin.databinding.ActivityMainBinding
import com.arifur.weatherappusingkotlin.databinding.ActivityMainBinding.inflate
import com.arifur.weatherappusingkotlin.model.WeatherModel
import com.arifur.weatherappusingkotlin.services.Services
import com.arifur.weatherappusingkotlin.services.utils.api_key
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {
    private var queryMap: HashMap<String, String> = HashMap<String,String>()
    private val weatherService= Services()
    val weather=
        MutableLiveData<WeatherModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        queryMap["appid"] = api_key
        queryMap["lat"] = "23.56998"
        queryMap["lon"] = "90.2356"



sumo()

    }
    fun sumo(){
        weatherService.getWeatherData(appid = "05f97c207bd8e3f4ed8cbeb774646919", lat = "23.56998", lon = "90.2356")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(@SuppressLint("CheckResult")
            object: DisposableSingleObserver<WeatherModel>(){
//                override fun onSuccess(value: WeatherModel?) {
//                    binding.temperatureNow.text = value.toString()
//
//                }
//
//                override fun onError(e: Throwable?) {
//                    Log.e("TAG", "onCreate: $e")
//
//                }

                override fun onSuccess(t: WeatherModel) {
                    Log.e("TAG", "onCreate: ${t.current} ${t.current?.weather?.get(0)?.icon}")
                    binding.temperatureNow.text = t.current?.sunrise.toString()
                }

                override fun onError(e: Throwable) {
                    Log.e("TAG", "onCreate: $e")
                    binding.temperatureNow.text = e.message

                }

            })
    }
}