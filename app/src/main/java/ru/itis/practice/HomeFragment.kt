package ru.itis.practice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import ru.itis.practice.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var binding: FragmentHomeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        binding?.run {
            val id = Integer.parseInt(arguments?.getString("id"))
            val vinyl = VinylRepository.vinyls[id-1]
            tvInfo.text = "TRACK LIST\n\n${vinyl.info}"
            tvHomeTitle.text = "${vinyl.name}\n${vinyl.singer}"

            context?.let { Glide
                .with(it.applicationContext)
                .asBitmap()
                .load(vinyl.url)
                .into(ivCover) }


            ivBack.setOnClickListener {
                findNavController().navigate(
                    R.id.action_homeFragment_to_historyFragment,
                )
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}