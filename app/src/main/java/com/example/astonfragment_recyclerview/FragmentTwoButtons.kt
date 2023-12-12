package com.example.fragmentaston

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentaston.databinding.FragmentTwoButtonsBinding
import com.example.fragmentaston.fragment.FragmentA
import com.example.fragmentaston.recyclerView.UserListFragment

class FragmentTwoButtons : Fragment() {
    private var _binding: FragmentTwoButtonsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTwoButtonsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val fragmentA = FragmentA()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragmentA)
                .addToBackStack(null)
                .commit()
        }

        binding.button2.setOnClickListener {
            val fragmentUserList = UserListFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragmentUserList)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}