package com.capstone.cikla.fragments.sedeFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.cikla.R
import com.capstone.cikla.adapter.adapterSede.SedeAdapter
import kotlinx.android.synthetic.main.fragment_campus.*


class CampusFragment : Fragment() {

    private lateinit var viewModel: SedeViewModel

    private fun getSede() {
        viewModel.sedeLiveData.observe(viewLifecycleOwner, {
            rvSede.apply {
                adapter = SedeAdapter(it, ::onItemClick)
                rvSede.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            }
        })
        viewModel.getSedes()
    }

    fun onItemClick(latitude: String?, longitude: String?) {
        //val intent = Intent(this, NavigationActivity::class.java)
        //startActivity(intent)
        //finish()
        //CampusFragmentDirections.actionCampusFragmentToMapFragment
        Log.e("latitud", latitude!!)
        Log.e("longitud", longitude!!)
        val action = CampusFragmentDirections.actionCampusFragmentToMapFragment(latitude, longitude)
        view?.findNavController()?.navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_campus, container, false)
        viewModel = ViewModelProvider(this).get(SedeViewModel::class.java)
        Log.e("Fragment Sede", "Aquí está la pantalla de sedes")
        getSede()
        return view
    }
    
}