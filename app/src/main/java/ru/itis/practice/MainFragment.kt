package ru.itis.practice

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.practice.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding?.run {
            btnMain.setOnClickListener {
                val text = etEmail.text.toString()
                val bundle = Bundle()
                bundle.putString("ARG_TEXT", text)

                if (text == "") {
                    Toast.makeText(activity,"для отправки текста требуется заполнить поле",Toast.LENGTH_SHORT).show()

                }
                else {
                    findNavController().navigate(
                        R.id.action_mainFragment_to_firstFragment,
                        args = bundle
                    )
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}