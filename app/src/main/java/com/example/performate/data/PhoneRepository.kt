package com.example.performate.data

import com.example.performate.data.model.PhoneResponseItem
import javax.inject.Inject

class PhoneRepository(private val remoteDataSource: PhoneRemoteDataSource){

    suspend fun getPhones(): List<PhoneResponseItem> = remoteDataSource.getPhones()
}