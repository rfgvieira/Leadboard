package com.example.leadboardactivity

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.leadboardactivity.databinding.ActivityPersonitemBinding

class PersonAdapter (private val leadList: List<PersonModel>, context: Context)
    : RecyclerView.Adapter<PersonAdapter.PersonHolder>(){

    private val cont = context
    private  lateinit var binding:ActivityPersonitemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        binding = ActivityPersonitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PersonHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        with(holder){
            with(leadList[position]){
                binding.tvName.text = name
                binding.tvPoints.text = points.toString()
                binding.tvPointstoday.text = pointsToday.toString()
                val evolution = evolutionRank(position+1,lastRank)
                binding.tvEvolution.text = evolution.toString()
                if(evolution < 0 )
                    binding.tvEvolution.setTextColor(ContextCompat.getColor(cont,R.color.red))
                else if(evolution > 0 )
                    binding.tvEvolution.setTextColor(ContextCompat.getColor(cont,R.color.green))
                else
                    binding.tvEvolution.setTextColor(ContextCompat.getColor(cont,R.color.text_muted))
            }
        }
    }

    private fun evolutionRank(current : Int, last : Int) : Int = last - current

    override fun getItemCount(): Int = leadList.size

    class PersonHolder(val binding: ActivityPersonitemBinding) : RecyclerView.ViewHolder(binding.root){

    }
}