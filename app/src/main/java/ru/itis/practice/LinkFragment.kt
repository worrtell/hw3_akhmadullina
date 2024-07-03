package ru.itis.practice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import ru.itis.practice.databinding.FragmentLinkBinding

class LinkFragment : Fragment(R.layout.fragment_link) {

    private var binding: FragmentLinkBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLinkBinding.bind(view)

        binding?.run {
            val id = Integer.parseInt(arguments?.getString("id"))
            val vinyl = VinylRepository.vinyls[id-1]
            tvLinkInfo.text = "TRACK LIST\n\n${vinyl.info}"
            tvLinkTitle.text = "${vinyl.name}\n${vinyl.singer}"

            context?.let { Glide
                .with(it.applicationContext)
                .asBitmap()
                .load(vinyl.url)
                .into(ivLinkCover) }


            ivLinkBack.setOnClickListener {
                findNavController().navigate(
                    R.id.action_linkFragment_to_historyFragment,
                )
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
