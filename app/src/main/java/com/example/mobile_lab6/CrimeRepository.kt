package com.example.mobile_lab6

import android.content.Context
import androidx.room.Room
import com.example.mobile_lab6.database.CrimeDatabase

private const val DATABASE_NAME = "crimedatabase"

class CrimeRepository private
constructor(context: Context) {

    private val database : CrimeDatabase = Room.databaseBuilder(
        context.applicationContext,
        CrimeDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val crimeDao = database.crimeDao()

    companion object {
        private var INSTANCE: CrimeRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }

        fun get(): CrimeRepository {
            return INSTANCE ?: throw IllegalStateException("CrimeRepository должен быть инициализован")
        }
    }
}