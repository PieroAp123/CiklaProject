package com.capstone.cikla

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_map.*


class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mapa: GoogleMap
    private val arguments: MapFragmentArgs by navArgs()

   /* override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            android.R.id.home -> {
                (activity as AppCompatActivity).onBackPressed()
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }*/

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setHomeButtonEnabled(true)
    }*/

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mapSede.onCreate(savedInstanceState)
        mapSede.onResume()
        mapSede.getMapAsync(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_map, container, false)
        return view
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mapa = googleMap
        createMarker()
    }

    private fun createMarker() {
        val latitudeCampus = arguments.latitude
        val longitudeCampus = arguments.longitude
        val coordinates = LatLng(latitudeCampus.toDouble(), longitudeCampus.toDouble())
        val marker = MarkerOptions().position(coordinates)
        mapa.addMarker(marker)
        mapa.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f), 4000, null
        )
    }


}