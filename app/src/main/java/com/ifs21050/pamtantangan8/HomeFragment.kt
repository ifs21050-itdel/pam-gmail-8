package com.ifs21050.pamtantangan8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21050.pamtantangan8.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), EmailListAdapter.OnItemClickListener {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Inisialisasi RecyclerView
        val recyclerView = binding.rvEmailList
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager

        // Contoh data email
        val emailList = listOf(
            Email("Dicoding", "rifa", "Content 1"),
            Email("Netflix", "tim netflix", "pembayaran telah gagal"),
            Email("iCloud", "icloud", "your iCloud storage is full")
            // Tambahkan data email lainnya sesuai kebutuhan
        )

        // Inisialisasi adapter dan terapkan ke RecyclerView
        val adapter = EmailListAdapter(emailList, this)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(email: Email) {
        // Tampilkan DetailFragment saat item diklik
        val detailFragment = DetailFragment.newInstance(email)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, detailFragment)
            .addToBackStack(null)
            .commit()
    }

    companion object {
        const val EXTRA_MESSAGE = "extra_message"
    }
}
