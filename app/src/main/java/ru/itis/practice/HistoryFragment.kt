package ru.itis.practice

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import ru.itis.practice.databinding.FragmentHistoryBinding
import ru.itis.practice.databinding.FragmentMainBinding

class HistoryFragment : Fragment(R.layout.fragment_history) {

    private var binding: FragmentHistoryBinding? = null
    private var adapter: VinylAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHistoryBinding.bind(view)

        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        binding?.run {
            adapter = VinylAdapter(
                list = VinylRepository.vinyls,
                glide = Glide.with(this@HistoryFragment),
                onClick = {
                    val bundle = Bundle()
                    bundle.putString("id", it.id.toString())
                    findNavController().navigate(
                        R.id.action_historyFragment_to_linkFragment,
                        args = bundle
                    )
                }
            )

            rvVinyls.adapter = adapter

            rvVinyls.layoutManager = LinearLayoutManager(requireContext())

            tvHistoryTitle.setOnClickListener {
                adapter?.updateDataset(VinylRepository.vinyls)
            }
        }
    }
}