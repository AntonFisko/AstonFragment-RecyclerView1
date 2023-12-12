package com.example.fragmentaston.recyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentaston.R

class UserListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_list, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        userAdapter = UserAdapter(getDummyUsers()) { user ->
            openEditUserFragment(user)
        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = userAdapter
    }

    private fun getDummyUsers(): List<User> {
        // Здесь можно загрузить список пользователей из базы данных или другого источника данных
        // В данном примере возвращается жестко заданный список для демонстрационных целей
        return listOf(
            User(R.drawable.user1,"Иван", "Иванов", "123456789"),
            User(R.drawable.user2,"Петр", "Петров", "987654321"),
            User(R.drawable.user3,"Мария", "Сидорова", "456789123")
        )
    }

    private fun openEditUserFragment(user: User) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val editUserFragment = EditUserFragment.newInstance(user)

        // Заменить текущий фрагмент (UserListFragment) на EditUserFragment
        fragmentTransaction.replace(R.id.container, editUserFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
