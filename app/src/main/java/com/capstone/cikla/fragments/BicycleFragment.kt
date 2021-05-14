package com.capstone.cikla.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.GridView
import com.capstone.cikla.R
import com.capstone.cikla.adapter.RVBicycleAdapter
import com.capstone.cikla.user.Bicycle


class BicycleFragment : Fragment() {

    private lateinit var adapter: RVBicycleAdapter
    private val bicycleList = mutableListOf<Bicycle>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bicycle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = RVBicycleAdapter(bicycleList)


    }


}