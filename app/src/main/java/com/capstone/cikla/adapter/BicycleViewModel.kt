package com.capstone.cikla.adapter

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.cikla.network.ApiInterface
import com.capstone.cikla.network.ApiService
import com.capstone.cikla.user.Bicycle
import com.capstone.cikla.user.Bicycles
import com.capstone.cikla.user.DataBicycle.ComponenteBicycle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BicycleViewModel: ViewModel() {

    private val api = ApiService().getRetrofit()
    val bicycleLiveData = MutableLiveData<List<Bicycle>>()
    val bicycleComponentLiveData = MutableLiveData<ComponenteBicycle>()

    fun getBicycle() {
        val service: ApiInterface = api.create(ApiInterface::class.java)
        val result: Call<Bicycles> = service.getBicycle()
        result.enqueue(object: Callback<Bicycles> {
            override fun onResponse(call: Call<Bicycles>, response: Response<Bicycles>) {
                val bicicletas = response.body()?.bicicletas
                Log.e("bicicletas", bicicletas.toString())
                bicycleLiveData.postValue(bicicletas)
            }

            override fun onFailure(call: Call<Bicycles>, t: Throwable) {
                Log.e("Fail", "No hay bicicletas")
            }


        })
    }

}