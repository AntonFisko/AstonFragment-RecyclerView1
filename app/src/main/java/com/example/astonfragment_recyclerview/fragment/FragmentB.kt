package com.example.fragmentaston.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentaston.R
import com.example.fragmentaston.databinding.FragmentBBinding


class FragmentB : Fragment() {
    private var _binding: FragmentBBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentBBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.buttonNext.setOnClickListener {
            val fragmentC = FragmentC.newInstance("Hello Fragment C")
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragmentC)
                .addToBackStack(null)
                .commit()
        }

        binding.buttonBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        return view
    }

    companion object {
        fun newInstance(): FragmentB {
            return FragmentB()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

