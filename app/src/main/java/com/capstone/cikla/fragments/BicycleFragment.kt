package com.capstone.cikla.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.GridView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capstone.cikla.R
import com.capstone.cikla.adapter.BicycleViewModel
import com.capstone.cikla.adapter.RVBicycleAdapter
import com.capstone.cikla.network.ApiInterface
import com.capstone.cikla.network.ApiService
import com.capstone.cikla.user.Bicycle
import com.capstone.cikla.user.User
import kotlinx.android.synthetic.main.fragment_bicycle.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create


class BicycleFragment : Fragment(), RVBicycleAdapter.ItemClickListener {

    private lateinit var viewModel: BicycleViewModel
    private lateinit var adapter: RVBicycleAdapter
    private val bicycleList = mutableListOf<Bicycle>()
    private val bicycleListString = MutableLiveData<List<Bicycle>>()


    private fun alertBicycleDetail() {
        val viewDialog = LayoutInflater.from(requireContext()).inflate(R.layout.activity_bicycle_detail, null)
        val dialogBuild = AlertDialog.Builder(requireContext())
        dialogBuild.setView(viewDialog)
                .setView(viewDialog)
                .show()


    }

    private fun getBicycle() {
        viewModel.bicycleLiveData.observe(viewLifecycleOwner, {
            gridCovid.apply {
                adapter = RVBicycleAdapter(it, this@BicycleFragment)
                //gridCovid.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                gridCovid.layoutManager = GridLayoutManager(requireContext(),2, GridLayoutManager.VERTICAL, false)
            }
        })
        viewModel.getBicycle()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_bicycle, container, false)
        viewModel = ViewModelProvider(this).get(BicycleViewModel::class.java)
        getBicycle()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClickItem(position: Int) {
        alertBicycleDetail()
    }


}