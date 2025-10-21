package az.tutorials.mentor108android

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import az.tutorials.mentor108android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = ItemAdapter(
        itemSelected = {
            binding.binIcon.visibility = if (it) View.VISIBLE else View.GONE
            binding.backIcon.visibility = if (it) View.VISIBLE else View.GONE
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecycler()
        loadDummyData()
        backPressed()
        deleteItems()
    }

    private fun setupRecycler() {
        binding.rcyItems.layoutManager = LinearLayoutManager(this)
        binding.rcyItems.adapter = adapter
    }

    private fun loadDummyData() {
        val dummy = listOf(
            Item(1,"Farid Ismayilov"),
            Item(2,"Nurlan Rashidov"),
            Item(3,"Ehtiram Mustafayev"),
            Item(4,"Javid"),
            Item(5,"Alishan"),
            Item(6,"Samid"),
            Item(7,"Mansur"),
            )
        adapter.submitList(dummy)
    }

    private fun backPressed(){
        binding.backIcon.setOnClickListener {
            if (adapter.selectedMode){
                adapter.selectedMode = false
                View.GONE
                adapter.notifyDataSetChanged()
            }
            binding.backIcon.visibility  = if (adapter.selectedMode) View.VISIBLE else View.GONE
            binding.binIcon.visibility  = if (adapter.selectedMode) View.VISIBLE else View.GONE
        }
    }

    private fun deleteItems(){
        binding.binIcon.setOnClickListener {
            val currentList = adapter.differ.currentList.toMutableList()
            val newList = currentList.filterNot { item ->
                adapter.selectedItems.contains(item.id)
            }
            adapter.submitList(newList)
            adapter.selectedMode = false
            adapter.selectedItems.clear()
            adapter.notifyDataSetChanged()
            binding.binIcon.visibility = View.GONE
            binding.backIcon.visibility = View.GONE
            }
        }

}