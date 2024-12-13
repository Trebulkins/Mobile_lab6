package com.example.mobile_lab6

import android.app.Application

class CriminalIntentApplication : Application()
{
    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}
