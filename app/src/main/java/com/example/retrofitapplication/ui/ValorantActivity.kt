package com.example.retrofitapplication.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapplication.databinding.ActivityValorantBinding
import com.example.retrofitapplication.models.UiEvents
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ValorantActivity : AppCompatActivity() {

    private val binding by lazy { ActivityValorantBinding.inflate(layoutInflater) }
    private val viewModel : ValorantViewModel by lazy {
        ViewModelProvider(this)[ValorantViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setValorantRecyclerView()
        setAgentList()
        viewModel.getAgents()
    }

    private fun setValorantRecyclerView() {

        binding.valorantRecyclerView.run {
            layoutManager = LinearLayoutManager(this@ValorantActivity)
            adapter = ValorantAdapter()
        }

        binding.valorantRefreshLayout.setOnRefreshListener {
            viewModel.getAgents()
            binding.valorantRefreshLayout.isRefreshing = false
        }
    }

    private fun setAgentList() {

        viewModel.agentsList.observe(this, Observer {

            when(it) {
                is UiEvents.Success -> {
                    (binding.valorantRecyclerView.adapter as ValorantAdapter).sumbitList(it.result)
                }

                is UiEvents.Error -> {
                    Toast.makeText(
                        this,
                        "${it.error}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is UiEvents.Loading -> {

                }
            }
        })
    }
}