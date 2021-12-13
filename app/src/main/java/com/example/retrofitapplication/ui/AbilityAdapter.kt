package com.example.retrofitapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitapplication.R
import com.example.retrofitapplication.databinding.SingleAbilityItemBinding
import com.example.retrofitapplication.models.Ability

class AbilityAdapter(
    private val abilities: List<Ability>
 ) : RecyclerView.Adapter<AbilityAdapter.AbilityViewHolder>() {

    class AbilityViewHolder(private val binding: SingleAbilityItemBinding): RecyclerView.ViewHolder(binding.root) {

        private val context by lazy { binding.root.context }

        fun bind(ability: Ability) {

            binding.run {
                name.text = ability.displayName
                description.text = ability.description

                Glide.with(context)
                    .load(ability.image)
                    .error(R.drawable.ic_launcher_background)
                    .into(image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilityViewHolder {
        return AbilityViewHolder(SingleAbilityItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: AbilityViewHolder, position: Int) {
        holder.bind(ability = abilities[position])
    }

    override fun getItemCount(): Int {
        return abilities.size
    }
}