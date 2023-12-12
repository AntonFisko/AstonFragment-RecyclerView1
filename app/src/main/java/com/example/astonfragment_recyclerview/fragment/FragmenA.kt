package com.example.fragmentaston.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.fragmentaston.R
import com.example.fragmentaston.databinding.FragmentABinding


class FragmentA : Fragment() {

    private var _binding: FragmentABinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentABinding.inflate(inflater, container, false)
        val view = binding.root

        binding.buttonNext.setOnClickListener {
            val fragmentB = FragmentB.newInstance()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragmentB)
                .addToBackStack(null)
                .commit()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
