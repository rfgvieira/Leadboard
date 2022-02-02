package com.example.leadboardactivity

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.leadboardactivity.databinding.ActivityPersonitemBinding
import java.text.FieldPosition

class PersonAdapter (private val leadList: List<PersonModel>, context: Context)
    : BaseAdapter(){

    private val cont = context
    private  lateinit var binding:ActivityPersonitemBinding

    override fun getCount(): Int = leadList.size

    override fun getItem(position : Int): Any = leadList[position]

    override fun getItemId(position : Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        if(convertView == null){

        }

        val person = leadList[position]
        binding = ActivityPersonitemBinding.inflate(LayoutInflater.from(parent?.context),parent,false)
        binding.tvEvolution.text = evolutionRank(person.atualRank,person.lastRank).toString()
        binding.tvName.text = person.name
        binding.tvPointstoday.text = "+${person.pointsToday.toString()}"
        binding.tvPoints.text = person.points.toString()
        return binding.cvLeadboarditem
    }

    private fun evolutionRank(current : Int, last : Int) : Int = last - current
}