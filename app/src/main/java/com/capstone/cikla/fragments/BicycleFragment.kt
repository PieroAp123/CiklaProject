package com.capstone.cikla.fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.ClipDescription
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.cikla.R
import com.capstone.cikla.adapter.BicycleViewModel
import com.capstone.cikla.adapter.RVBicycleAdapter
import com.capstone.cikla.adapter.adapterComponent.BicycleComponentAdapter
import com.capstone.cikla.fragments.sedeFragment.CampusFragmentDirections
import com.capstone.cikla.preferences.BicycleApplication.Companion.prefs
import com.capstone.cikla.user.Bicycle
import com.capstone.cikla.user.DataBicycle.ComponenteBicycle
import kotlinx.android.synthetic.main.activity_bicycle_detail.*
import kotlinx.android.synthetic.main.activity_bicycle_detail.view.*
import kotlinx.android.synthetic.main.fragment_bicycle.*


class BicycleFragment : Fragment() {

    private lateinit var viewModel: BicycleViewModel


    @SuppressLint("SetTextI18n")
    fun onItemClick(description: String, category: String, imageBicycle: String, sede: String, color: String, bicycleComponent: List<ComponenteBicycle>, codeComponent: String) {
        val viewDialog = LayoutInflater.from(requireContext()).inflate(R.layout.activity_bicycle_detail, null)
        val dialogBuild = AlertDialog.Builder(requireContext())
        val bytes = Base64.decode(imageBicycle, Base64.DEFAULT)
        val bitmap: Bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
        Log.e("Código Bici", codeComponent)
        Log.e("Descripción Bici", description)
        Log.e("Nombre de Categoría", category)
        Log.e("Nombre de Imagen", imageBicycle)
        Log.e("Nombre de sede", sede)
        Log.e("Nombre de color", color)
        viewDialog.titleCode.text = "$codeComponent - "
        viewDialog.titleDetailBicycle.text = description
        viewDialog.txtCategory.text = category
        viewDialog.imageViewBicycle.setImageBitmap(bitmap)
        viewDialog.sedeBicycle.text = sede
        viewDialog.coloBicycle.text = color
        //val bicycleComponent2: List<ComponenteBicycle>? = null
        viewDialog.recyclerComponent.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = BicycleComponentAdapter(bicycleComponent)

        }

        dialogBuild.setView(viewDialog)
            .setView(viewDialog)
            .setPositiveButton("Agregar") { _, _ -> Toast.makeText(requireContext(), "Bicicleta Agregada", Toast.LENGTH_SHORT).show()}
            .show()

           /* prefs.saveCode(codeComponent)
            prefs.saveNameBicycle(description)
            prefs.saveImage(imageBicycle)
            prefs.saveNameCategory(category)
            prefs.saveNameColor(color)
            prefs.saveSede(sede)*/

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

    private fun getBicycle() {

        viewModel.bicycleLiveData.observe(viewLifecycleOwner, {
            gridCovid.apply {
                adapter = RVBicycleAdapter(it, ::onItemClick)
                //gridCovid.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                gridCovid.layoutManager = GridLayoutManager(requireContext(),2, GridLayoutManager.VERTICAL, false)
            }
        })
        viewModel.getBicycle()
    }




}