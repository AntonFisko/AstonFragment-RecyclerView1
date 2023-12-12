package com.example.fragmentaston.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.fragmentaston.R
import com.example.fragmentaston.databinding.FragmentCBinding

class FragmentC : Fragment() {
    private var receivedString: String? = null
    private var _binding: FragmentCBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.textView.text = receivedString

        binding.buttonNext.setOnClickListener {
            val fragmentD = FragmentD.newInstance()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragmentD)
                .addToBackStack(null)
                .commit()
        }

        binding.buttonReset.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack(
                null,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )

            val fragmentA = FragmentA()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragmentA)
                .commit()
        }

        return view
    }

    companion object {
        fun newInstance(receivedString: String): FragmentC {
            val fragment = FragmentC()
            fragment.receivedString = receivedString
            return fragment
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}