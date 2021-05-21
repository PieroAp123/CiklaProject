package com.capstone.cikla.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.GridView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capstone.cikla.R
import com.capstone.cikla.adapter.RVBicycleAdapter
import com.capstone.cikla.user.Bicycle
import kotlinx.android.synthetic.main.fragment_bicycle.*


class BicycleFragment : Fragment() {

    private lateinit var adapter: RVBicycleAdapter
    private val bicycleList: List<Bicycle> = listOf(
            Bicycle("https://i.ibb.co/42LSDGn/bicycle1.jpg", "007CD"),
            Bicycle("https://i.ibb.co/sWspTDr/bicycle2.jpg", "008CD"),
            Bicycle("https://i.ibb.co/SPtGqhJ/bicycle3.jpg", "009CD"),
            Bicycle("https://i.ibb.co/5FyqzXr/bicycle4.jpg", "010CD"),
            Bicycle("https://i.ibb.co/vjmWRSG/bicycle5.jpg", "011CD"),
            Bicycle("https://i.ibb.co/3pJ7Cm1/bicycle6.jpg", "012CD")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun alertBicycleDetail() {
        val viewDialog = LayoutInflater.from(requireContext()).inflate(R.layout.activity_bicycle_detail, null)
        val dialogBuild = AlertDialog.Builder(requireContext())

        dialogBuild.setView(viewDialog)
                .setView(viewDialog)
                .show()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bicycle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = RVBicycleAdapter(bicycleList) {
            alertBicycleDetail()
        }
        gridCovid.adapter = adapter
        //gridCovid.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        gridCovid.layoutManager = GridLayoutManager(requireContext(),2, GridLayoutManager.VERTICAL, false)
    }


}