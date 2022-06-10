package com.example.performate.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.performate.R
import com.example.performate.databinding.ActivityMainBinding
import com.example.performate.ui.detail.DetailActivity
import com.example.performate.ui.detail.DetailActivity.Companion.DETAIL_DATA
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    private val mainViewModel: MainViewModel by viewModels {
        mainViewModelFactory
    }

    private lateinit var binding: ActivityMainBinding
    private var times = System.currentTimeMillis()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val format = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())

        binding.txtDate.text = format.format(times)

        mainViewModel.getPhones()

        val adapter = MainAdapter {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DETAIL_DATA, it)
            startActivity(intent)
        }

        mainViewModel.loading.observe(this) {
            if (it) {
                binding.loading.visibility = View.VISIBLE
            } else {
                binding.loading.visibility = View.GONE
            }
        }

        binding.rvMain.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvMain.adapter = adapter

        mainViewModel.phones.observe(this) {
            adapter.submitList(it)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.refresh -> {
                mainViewModel.getPhones()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}