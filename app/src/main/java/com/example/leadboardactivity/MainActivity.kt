package com.example.leadboardactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leadboardactivity.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter: PersonAdapter
    private var personList : ArrayList<PersonModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        addPeople()
        adapter = PersonAdapter(personList,this)
        binding.gvLeadboard.adapter = adapter
    }

    private fun addPeople(){
        val lastIndex = 22
        for(i in 1..lastIndex){
             var pessoa : PersonModel = PersonModel(
                "Juninho ${i}", 500 - (i*10), 200 - (i*10), i, lastIndex-i, "aaaa"
             )
            personList.add(pessoa)
        }
    }
}