package com.android.example.develhopeandroid2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.example.develhopeandroid2.databinding.FragmentHomeBinding

import kotlinx.coroutines.*

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private var currentValue: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.button.setOnClickListener {
            val inputValue = binding.editText.text.toString().toIntOrNull()
            if (inputValue != null) {
                coroutineScope.launch {
                    delay(2000)
                    currentValue = inputValue + 1
                    binding.textHome.text = currentValue.toString()
                }
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        coroutineScope.cancel()
    }
}
