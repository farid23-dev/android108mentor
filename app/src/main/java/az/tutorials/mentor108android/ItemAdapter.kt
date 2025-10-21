package az.tutorials.mentor108android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import az.tutorials.mentor108android.databinding.TitleItemBinding

class ItemAdapter(
    var itemList: List<Item>,
    private val onClick: (Item) -> Unit
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val binding = TitleItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(
        holder: ItemViewHolder,
        position: Int
    ) {
        val item = itemList[position]
        holder.bind(item)
    }

    inner class ItemViewHolder(val binding: TitleItemBinding): RecyclerView.ViewHolder(binding.root){
        val titleText = itemView.findViewById<TextView>(R.id.title)
        fun bind(item: Item){
            titleText.text = item.title
            itemView.setOnClickListener {
                onClick(item)
            }
        }
    }
}


