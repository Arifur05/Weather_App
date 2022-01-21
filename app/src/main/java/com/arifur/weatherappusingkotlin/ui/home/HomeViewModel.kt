//package com.arifur.bottomnavkotlin.ui.home
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//
//class HomeViewModel : ViewModel() {
//
//    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }
//    val text: LiveData<String> = _text
//}



import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arifur.weatherappusingkotlin.model.WeatherModel
import com.arifur.weatherappusingkotlin.services.Services

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers



class HomeViewModel : ViewModel() {



    private val weatherService= Services()
    private val disposables= CompositeDisposable()

    val weatherModel= MutableLiveData<WeatherModel>()
    val loadingError= MutableLiveData<Boolean>()
    val loading= MutableLiveData<Boolean>()

    fun refreshWeather(){
        fetchWeather()
    }

    private fun fetchWeather() {
        loading.value = true
        disposables.add(
            weatherService.getWeatherData(appid = "05f97c207bd8e3f4ed8cbeb774646919", lat = "23.56998", lon = "90.2356")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<WeatherModel>(){
                    override fun onSuccess(value: WeatherModel) {
                        Log.d("HomeViewModel", "onSuccess`: $value")
                        weatherModel.value = value
                        loadingError.value =false
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        loading.value = false
                        loadingError.value =true
                        Log.e("HomeViewModel", "onError: ${e.message}")
                    }

                }
                ))



    }


}