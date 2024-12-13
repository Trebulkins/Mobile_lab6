package com.example.mobile_lab6

import androidx.lifecycle.ViewModel

class CrimeListViewModel : ViewModel() {
    val crimes = mutableListOf<Crime>()
    init {
        for (i in 0 until 100) {
            val crime = Crime()
            crime.title = "Преступление #$i"
            crime.isSolved = i % 2 == 0
            crimes += crime
        }
    }

}