package com.capstone.cikla.fragments.rentalFragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.cikla.network.ApiInterface
import com.capstone.cikla.network.ApiService
import com.capstone.cikla.network.PlanTarifarioResponse
import com.capstone.cikla.user.PlanTarifario.Tarifario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RentalFragmentViewModel: ViewModel() {

    private val api = ApiService().getRetrofit()
    val tarifarioListData = MutableLiveData<List<Tarifario>>()
    val itemLiveData = MutableLiveData<ArrayList<String>>()
    val itemHourLiveData = MutableLiveData<ArrayList<Float>>()
    val itemIdLiveData = MutableLiveData<ArrayList<Int>>()
    val itemPriceLiveData = MutableLiveData<ArrayList<Float>>()
    var listString: ArrayList<String>? = null
    var listIntHour: ArrayList<Float>? = null
    var listId: ArrayList<Int>? = null
    var listPrice: ArrayList<Float>? = null

    fun getTarifario() {
        listString = ArrayList()
        listIntHour = ArrayList()
        listId = ArrayList()
        listPrice = ArrayList()
        val service: ApiInterface = api.create(ApiInterface::class.java)
        val result: Call<PlanTarifarioResponse> = service.getPlanTarifario()
        result.enqueue(object: Callback<PlanTarifarioResponse> {
            override fun onResponse(call: Call<PlanTarifarioResponse>, response: Response<PlanTarifarioResponse>) {
                val tarifarios = response.body()?.planesTarifarios
                tarifarios?.forEach {
                    listString!!.add(it.descriptionTarifario)
                    listIntHour!!.add(it.hours)
                    listId!!.add(it.id)
                    listPrice!!.add(it.pecio)
                }
                itemIdLiveData.postValue(listId)
                itemLiveData.postValue(listString)
                itemHourLiveData.postValue(listIntHour)
                itemPriceLiveData.postValue(listPrice)
                Log.e("Precio Tarifa", listId.toString())
                Log.e("Id Tarifa", listId.toString())
                Log.e("Hora Tarifa", listIntHour.toString())
                Log.e("nombre Tarifa", listString.toString())
                Log.e("tarifario", tarifarios.toString())
                tarifarioListData.postValue(tarifarios)
            }

            override fun onFailure(call: Call<PlanTarifarioResponse>, t: Throwable) {
                Log.e("Unsucces", "No entró al call")
            }

        })
    }

    fun getTarifario2() {
        listIntHour = ArrayList()
        val service: ApiInterface = api.create(ApiInterface::class.java)
        val result: Call<PlanTarifarioResponse> = service.getPlanTarifario()
        result.enqueue(object: Callback<PlanTarifarioResponse> {
            override fun onResponse(call: Call<PlanTarifarioResponse>, response: Response<PlanTarifarioResponse>) {
                val tarifarios = response.body()?.planesTarifarios
                tarifarios?.forEach {
                    listIntHour!!.add(it.hours)
                }
                itemHourLiveData.postValue(listIntHour)
                Log.e("HoraTarifa", listIntHour.toString())
                Log.e("tarifario", tarifarios.toString())
            }

            override fun onFailure(call: Call<PlanTarifarioResponse>, t: Throwable) {
                Log.e("Unsucces", "No entró al call")
            }

        })
    }

}