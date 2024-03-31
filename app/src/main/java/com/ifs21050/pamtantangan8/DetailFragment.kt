package com.ifs21050.pamtantangan8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ifs21050.pamtantangan8.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Terima objek Email dari argumen
        val email = arguments?.getSerializable(ARG_EMAIL) as? Email

        // Tampilkan detail email di dalam DetailFragment
        email?.let {
            binding.apply {
                textViewSubject.text = it.subject
                textViewSender.text = it.sender
                textViewContent.text = it.content
            }
        }
    }

    companion object {
        const val EXTRA_INFO = "extra_info"
        private const val ARG_EMAIL = "arg_email"

        // Metode newInstance untuk membuat instance DetailFragment dengan Email sebagai argumen
        fun newInstance(email: Email): DetailFragment {
            val fragment = DetailFragment()
            val args = Bundle()
            args.putSerializable(ARG_EMAIL, email)

            fragment.arguments = args
            return fragment
        }
    }
}
