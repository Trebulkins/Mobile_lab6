package com.example.mobile_lab6

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import java.util.UUID

class CrimeDetailViewModel: ViewModel() {
    private val crimeRepository = CrimeRepository.get()
    private val crimeIdLiveData = MutableLiveData<UUID>()

    var crimeLiveData: LiveData<Crime?> = crimeIdLiveData.switchMap { crimeId ->
        Log.d("CrimeDetailViewModel", "Получаем Crime с ID: $crimeId")
        crimeRepository.getCrime(crimeId)
    }

    fun loadCrime(crimeId: UUID) {
        Log.d("CrimeDetailViewModel", "Загружаем Crime с ID: $crimeId")
        crimeIdLiveData.value = crimeId
    }

    fun saveCrime(crime: Crime) {
        Log.d("CrimeDetailViewModel", "Сохраняем Crime: $crime")
        crimeRepository.updateCrime(crime)
    }
}
