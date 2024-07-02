package ru.itis.practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.model.Model
import com.bumptech.glide.request.transition.Transition.ViewAdapter
import ru.itis.practice.databinding.ItemVinylBinding

class VinylAdapter (
    private var list: List<Vinyl>,
    private val glide: RequestManager,
    private val onClick: (Vinyl) -> Unit,
) : RecyclerView.Adapter<VinylHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VinylHolder = VinylHolder(
        binding = ItemVinylBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onClick = onClick,
    )

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VinylHolder, position: Int) {
        holder.onBind(list[position])
    }

    fun updateDataset(newList: List<Vinyl>) {
        list = newList
        notifyDataSetChanged()
    }
}