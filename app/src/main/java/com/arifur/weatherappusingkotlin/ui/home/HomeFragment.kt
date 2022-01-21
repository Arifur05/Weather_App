package com.arifur.weatherappusingkotlin.ui.home

import HomeViewModel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.arifur.weatherappusingkotlin.MainActivity
import com.arifur.weatherappusingkotlin.R
import com.arifur.weatherappusingkotlin.databinding.FragmentHomeBinding
import com.arifur.weatherappusingkotlin.model.WeatherModel
import com.arifur.weatherappusingkotlin.services.utils.BASE_API_IMAGE
import com.squareup.picasso.Picasso

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        homeViewModel.refreshWeather()

        loadWeatherData()
        return root
    }

    private fun loadWeatherData(){
        homeViewModel.weatherModel.observe(viewLifecycleOwner, Observer {
                weather: WeatherModel -> weather.let {
            print("called")
            binding.layoutWeather.visibility = View.VISIBLE
            binding.loadingView.visibility = View.GONE
            binding.temperatureNow.text = it.current?.temp.toString() + " °C"
            binding.placeName.text = it.timezone
            binding.weatherState.text = it.current?.weather?.get(0)?.description
            try {
                Picasso.get()
                    .load(BASE_API_IMAGE+it.current?.weather?.get(0)?.icon+"@4x.png")
                    .resize(50, 50)
                    .centerCrop()
                    .into(binding.weatherIcon)
            }
            catch (e: Exception) {

            }

        }
        })

        homeViewModel.loadingError.observe(viewLifecycleOwner, Observer {
            isError -> isError.let {
                binding.layoutWeather.visibility = if (it) View.VISIBLE else View.GONE
        }
        })

        homeViewModel.loading.observe(viewLifecycleOwner, Observer {
            isLoading -> isLoading.let {
                binding.loadingView.visibility = if(it) View.VISIBLE else View.GONE
            if(it){
                binding.layoutWeather.visibility = View.GONE
            }
            else{
                binding.layoutWeather.visibility = View.VISIBLE
            }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}