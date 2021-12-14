package com.example.retrofitapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitapplication.R
import com.example.retrofitapplication.databinding.SingleValorantItemBinding
import com.example.retrofitapplication.models.ValorantModel

class ValorantAdapter: RecyclerView.Adapter<ValorantAdapter.ValorantViewHolder>() {

    private val agentsList = mutableListOf<ValorantModel>()

    class ValorantViewHolder(private val binding: SingleValorantItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val context by lazy { binding.root.context }
        fun bind(valorantModel: ValorantModel) {
            binding.run {
                agentNameTextView.text = valorantModel.name
                developerNameTextView.text = "Developed By -: ${valorantModel.developerName}"
                descriptionTextView.text = valorantModel.description

                Glide.with(context)
                    .load(valorantModel.image)
                    .error(R.drawable.ic_launcher_background)
                    .into(binding.agentIconImageView)

                abilitiesRecyclerView.run {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = AbilityAdapter(valorantModel.abilities)
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
        holder.bind(valorantModel = agentsList[position])
    }

    override fun getItemCount(): Int {
        return agentsList.size
    }

    fun sumbitList(agentsList: List<ValorantModel>) {
        this.agentsList.clear()
        this.agentsList.addAll(agentsList)
        notifyDataSetChanged()
    }
}