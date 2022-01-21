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
import com.arifur.weatherappusingkotlin.R
import com.arifur.weatherappusingkotlin.databinding.FragmentHomeBinding
import com.arifur.weatherappusingkotlin.model.WeatherModel
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
        homeViewModel.weatherModel.observe(viewLifecycleOwner, Observer {
                weather: WeatherModel -> weather.let {
            print("called")
            binding.temperatureNow.text = it.current?.temp.toString()
            Picasso.get().load(it.current?.weather?.get(0)?.icon).into(binding.weatherImage)
        }
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}