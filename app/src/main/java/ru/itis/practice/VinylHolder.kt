package ru.itis.practice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import ru.itis.practice.databinding.ItemVinylBinding

class VinylHolder (
    private val binding: ItemVinylBinding,
    private val glide: RequestManager,
    private val onClick: (Vinyl) -> Unit,
) : ViewHolder(binding.root) {
    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    private val context: Context
        get() = itemView.context

    fun onBind(vinyl: Vinyl) {

        binding.run {
            tvVinyl.text = vinyl.name
            tvSinger.text = vinyl.singer

            glide
                .load(vinyl.url)
                .error(R.drawable.baseline_settings_24)
                .placeholder(R.drawable.img)
                .apply(requestOptions)
                .into(ivImage)

            root.setOnClickListener {
                onClick.invoke(vinyl)
            }
        }
    }
}