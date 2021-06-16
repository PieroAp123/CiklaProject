package com.capstone.cikla.preferences

import android.content.Context

class Prefs(val context: Context) {

    val SHARED_NAME = "MyDtb"
    val SHARED_BICYCLE_CATEGORY= "category"
    val SHARED_BICYCLE_COLOR = "color"
    val SHARED_BICYCLE_SEDE = "sede"
    val SHARED_BICYCLE_CODE = "code"
    val SHARED_BICYCLE_NAME = "nameBicycle"
    val SHARED_BICYCLE_IMAGE = "image"
    val SHARED_BICYCLE_TARIFAS = "Tarifario"
    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveNameCategory(name: String) {
        storage.edit().putString(SHARED_BICYCLE_CATEGORY, name).apply()
    }

    fun saveNameColor(nameColor: String) {
        storage.edit().putString(SHARED_BICYCLE_COLOR, nameColor).apply()
    }

    fun saveSede(nameSede: String) {
        storage.edit().putString(SHARED_BICYCLE_SEDE, nameSede).apply()
    }

    fun saveCode(nameCode: String) {
        storage.edit().putString(SHARED_BICYCLE_CODE, nameCode).apply()
    }

    fun saveNameBicycle(nameBicycle: String) {
        storage.edit().putString(SHARED_BICYCLE_NAME, nameBicycle).apply()
    }

    fun saveImage(imageBicycle: String) {
        storage.edit().putString(SHARED_BICYCLE_IMAGE, imageBicycle).apply()
    }

    fun saveNameTarifa(nameTarifa: String) {
        storage.edit().putString(SHARED_BICYCLE_TARIFAS, nameTarifa).apply()
    }

    fun getNameTarifa(): String {
        return storage.getString(SHARED_BICYCLE_TARIFAS, "")!!
    }

    fun getImage(): String {
        return storage.getString(SHARED_BICYCLE_IMAGE, "")!!
    }

    fun getNameBicycle(): String {
        return storage.getString(SHARED_BICYCLE_NAME, "")!!
    }

    fun getCode(): String {
        return storage.getString(SHARED_BICYCLE_CODE, "")!!
    }

    fun getName(): String {
        return storage.getString(SHARED_BICYCLE_CATEGORY, "")!!
    }

    fun getNameColor(): String {
        return storage.getString(SHARED_BICYCLE_COLOR,"")!!
    }

    fun getSede(): String {
        return storage.getString(SHARED_BICYCLE_SEDE, "")!!
    }

}

