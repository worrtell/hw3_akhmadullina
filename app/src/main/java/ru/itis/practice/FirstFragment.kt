package ru.itis.practice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import ru.itis.practice.databinding.FragmentFirstBinding

// Search

class FirstFragment : Fragment(R.layout.fragment_first) {

    private var binding: FragmentFirstBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)

        val text = arguments?.getString("ARG_TEXT") ?: "o-oyy"

        binding?.run {
            tvFirstTitle.text = "$text (${tvFirstTitle.text})"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}