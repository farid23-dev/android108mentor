package az.tutorials.mentor108android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import az.tutorials.mentor108android.databinding.ItemRowBinding

class ItemAdapter(
    private val itemSelected: (Boolean) -> Unit
) : RecyclerView.Adapter<ItemAdapter.VH>() {

    var selectedMode = false
    val selectedItems = mutableSetOf<Int>()

    private val diffCallback = object : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
            oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean =
            oldItem == newItem
    }
    val differ = AsyncListDiffer(this, diffCallback)
    fun submitList(items: List<Item>) = differ.submitList(items)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = differ.currentList[position]

        with(holder.binding) {
            tvId.text = item.id.toString()
            tvName.text = item.name
            checkBox.visibility = if (selectedMode) View.VISIBLE else View.GONE
            root.setOnLongClickListener {
                if (!selectedMode){
                    selectedMode = true
                    itemSelected(selectedMode)
                    notifyDataSetChanged()
                }
                true
            }
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) selectedItems.add(item.id)
                else selectedItems.remove(item.id)
            }
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class VH(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)
}