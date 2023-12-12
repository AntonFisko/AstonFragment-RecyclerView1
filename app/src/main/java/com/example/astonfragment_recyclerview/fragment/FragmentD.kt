package com.example.fragmentaston.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.fragmentaston.R
import com.example.fragmentaston.databinding.FragmentCBinding
import com.example.fragmentaston.databinding.FragmentDBinding

class FragmentD : Fragment() {

    private var _binding: FragmentDBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDBinding.inflate(inflater, container, false)
        val view = binding.root
        val fragmentD = FragmentD().toString()
        binding.buttonNext.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack(
                fragmentD,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )

            val fragmentB = FragmentB.newInstance()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragmentB)
                .commit()
        }

        return view
    }

    companion object {
        fun newInstance(): FragmentD {
            return FragmentD()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}