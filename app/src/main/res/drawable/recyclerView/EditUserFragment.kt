package com.example.fragmentaston.recyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentaston.R
import com.example.fragmentaston.databinding.FragmentEditUserBinding


class EditUserFragment : Fragment() {

    private lateinit var user: User
    private var _binding: FragmentEditUserBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        user = arguments?.getParcelable(ARG_USER) ?: User(R.drawable.user4,"", "", "")
        displayUserData()

        binding.saveButton.setOnClickListener {
            saveUserData()
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    private fun displayUserData() {
        binding.editFirstName.setText(user.firstName)
        binding.editLastName.setText(user.lastName)
        binding.editPhoneNumber.setText(user.phoneNumber)
    }

    private fun saveUserData() {
        user.firstName = binding.editFirstName.text.toString()
        user.lastName = binding.editLastName.text.toString()
        user.phoneNumber = binding.editPhoneNumber.text.toString()

        // Отправка обновленных данных обратно в UserListFragment
        val result = Bundle().apply {
            putParcelable(ARG_USER, user)
        }
        parentFragmentManager.setFragmentResult(EDIT_USER_REQUEST_KEY, result)
    }

    companion object {
        private const val ARG_USER = "arg_user"
        const val EDIT_USER_REQUEST_KEY = "edit_user_request_key"

        fun newInstance(user: User): EditUserFragment {
            val fragment = EditUserFragment()
            val args = Bundle().apply {
                putParcelable(ARG_USER, user)
            }
            fragment.arguments = args
            return fragment
        }
    }
}