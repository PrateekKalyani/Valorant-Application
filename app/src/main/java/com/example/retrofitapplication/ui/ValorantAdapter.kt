package com.example.retrofitapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitapplication.R
import com.example.retrofitapplication.databinding.SingleValorantItemBinding
import com.example.retrofitapplication.models.ValorantAgentModel

class ValorantAdapter: RecyclerView.Adapter<ValorantAdapter.ValorantViewHolder>() {

    private val agentsList = mutableListOf<ValorantAgentModel>()

    class ValorantViewHolder(private val binding: SingleValorantItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val context by lazy { binding.root.context }
        fun bind(valorantAgentModel: ValorantAgentModel) {
            binding.run {
                agentNameTextView.text = valorantAgentModel.name
                developerNameTextView.text = "Developed By -: ${valorantAgentModel.developerName}"
                descriptionTextView.text = valorantAgentModel.description

                Glide.with(context)
                    .load(valorantAgentModel.image)
                    .error(R.drawable.ic_launcher_background)
                    .into(binding.agentIconImageView)

                abilitiesRecyclerView.run {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = AbilityAdapter(valorantAgentModel.abilities)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValorantViewHolder {

        return ValorantViewHolder(binding = SingleValorantItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ValorantViewHolder, position: Int) {
        holder.bind(valorantAgentModel = agentsList[position])
    }

    override fun getItemCount(): Int {
        return agentsList.size
    }

    fun sumbitList(agentsList: List<ValorantAgentModel>) {
        this.agentsList.clear()
        this.agentsList.addAll(agentsList)
        notifyDataSetChanged()
    }
}