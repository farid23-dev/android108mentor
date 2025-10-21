package az.tutorials.mentor108android

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import az.tutorials.mentor108android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = ItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecycler()
        loadDummyData()
    }

    private fun setupRecycler() {
        binding.rcyItems.layoutManager = LinearLayoutManager(this)
        binding.rcyItems.adapter = adapter
    }

    private fun loadDummyData() {
        val dummy = List(10) { i ->
            Item(id = i + 1, name = "User ${(i + 1)}")
        }
        adapter.submitList(dummy)
    }
}