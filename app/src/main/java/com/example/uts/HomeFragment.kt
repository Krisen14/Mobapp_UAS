package com.example.uts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {
    private val ARG_PARAM1 = "param1"
    private val ARG_PARAM2 = "param2"
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Inisialisasi RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Buat daftar item (contoh data)
        val itemList = listOf(
            Item(R.drawable.resep1, "Item 1"),
            Item(R.drawable.resep2, "Item 2"),
            // Tambahkan item lainnya di sini
        )

        // Inisialisasi adapter dan mengatur ke RecyclerView
        adapter = ItemAdapter(itemList)
        recyclerView.adapter = adapter

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
