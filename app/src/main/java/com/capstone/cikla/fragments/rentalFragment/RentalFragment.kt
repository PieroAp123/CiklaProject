package com.capstone.cikla.fragments.rentalFragment

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.capstone.cikla.R
import com.capstone.cikla.fragments.sedeFragment.SedeViewModel
import com.capstone.cikla.network.PlanTarifarioResponse
import com.capstone.cikla.preferences.BicycleApplication.Companion.prefs
import com.capstone.cikla.user.PlanTarifario.Tarifario
import kotlinx.android.synthetic.main.fragment_rental.*

class RentalFragment : Fragment() {

    //private val arguments: RentalFragmentArgs by navArgs()
    private lateinit var viewModelRental: RentalFragmentViewModel
    val tarifa: Tarifario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("SetTextI18n")
    fun set() {
        val codeBicycle = prefs.getCode()
        val nameBicycle = prefs.getNameBicycle()
        val imageBicycle = prefs.getImage()
        val nameCategory = prefs.getName()
        val nameColor = prefs.getNameColor()
        val nameSede = prefs.getSede()
        Log.e("codeBicycle", codeBicycle)
        Log.e("nameBicycle", nameBicycle)
        Log.e("imageBicycle", imageBicycle)
        Log.e("nombreCategoria", nameCategory)
        Log.e("nombreColor", nameColor)
        Log.e("nombreSede", nameSede)
        val bytes = Base64.decode(imageBicycle, Base64.DEFAULT)
        val bitmap: Bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
        rentalTitleCode.text = "$codeBicycle - "
        rentalTitleDetailBicycle.text = nameBicycle
        rentalImageViewBicycle.setImageBitmap(bitmap)
        rentalTxtCategory.text = nameCategory
        rentalColorBicycle.text = nameColor
        rentalSedeBicycle.text = nameSede
    }

    fun planTarifario() {
        viewModelRental.itemLiveData.observe(viewLifecycleOwner, {
            val listaNombre = viewModelRental.listString
            val arrayHourTarifa = viewModelRental.listIntHour
            val arrayIdTarifa = viewModelRental.listId
            val arrayPrecio = viewModelRental.listPrice
            Log.e("nombre de tarifa", listaNombre.toString())
            Log.e("hora de tarifa", arrayHourTarifa.toString())
            val adaptador = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, listaNombre!!.toList() )
            val listIdTarifa = arrayIdTarifa!!.toList()
            val listHourTarifa = arrayHourTarifa!!.toList()
            val listPrecioTarifa = arrayPrecio!!.toList()
            spinnerTarifario.adapter = adaptador
            spinnerTarifario.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
                @SuppressLint("SetTextI18n")
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    //Toast.makeText(requireContext(),"Horas " + listHourTarifa[position] + " x S/" + listPrecioTarifa[position] , Toast.LENGTH_SHORT).show()
                    precioPorHora.text =listHourTarifa[position].toString() + "hrs"  + " * S/" + listPrecioTarifa[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(requireContext(),"jaks", Toast.LENGTH_SHORT).show()
                }

            }
        })
        viewModelRental.getTarifario()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        set()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_rental, container, false)
        viewModelRental = ViewModelProviders.of(this).get(RentalFragmentViewModel::class.java)
        planTarifario()
        return view
    }
}