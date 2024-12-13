package com.example.mobile_lab6.database

import androidx.room.Dao
import androidx.room.Query
import com.example.mobile_lab6.Crime
import java.util.UUID

@Dao
interface CrimeDao {
    @Query("SELECT * FROM crime")
    fun getCrimes(): List<Crime>
    @Query("SELECT * FROM crime WHERE id=(:id)")
    fun getCrime(id: UUID): Crime?
}
