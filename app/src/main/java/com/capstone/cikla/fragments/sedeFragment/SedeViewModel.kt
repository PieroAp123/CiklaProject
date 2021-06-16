package com.capstone.cikla.fragments.sedeFragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.cikla.network.ApiInterface
import com.capstone.cikla.network.ApiService
import com.capstone.cikla.network.SedeResponse
import com.capstone.cikla.user.DataBicycle.Sede
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SedeViewModel: ViewModel() {

    private val api = ApiService().getRetrofit()
    val sedeLiveData = MutableLiveData<List<Sede>>()

    fun getSedes() {
        val service: ApiInterface = api.create(ApiInterface::class.java)
        val result: Call<SedeResponse> = service.getSedes()
        result.enqueue(object: Callback<SedeResponse> {
            override fun onResponse(call: Call<SedeResponse>, response: Response<SedeResponse>) {
                val sedes = response.body()?.sede
                sedeLiveData.postValue(sedes)
            }

            override fun onFailure(call: Call<SedeResponse>, t: Throwable) {
                Log.e("Fail", "No hay sede")
            }

        })
    }

}