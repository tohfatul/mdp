package com.example.assignment_7_quiz_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.assignment_7_quiz_app.databinding.FragmentHomeBinding
import com.example.assignment_7_quiz_app.utils.BaseFragment


class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.apply {
            btnStart.setOnClickListener {
                val directions = HomeFragmentDirections.actionHomeFragmentToSplashFragment()
                findNavController().navigate(directions)
            }
        }
        return  binding.root
    }

}