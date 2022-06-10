package com.example.performate.data

import com.example.performate.data.model.PhoneResponseItem

class PhoneRemoteDataSource(private val service: ApiService) {

    suspend fun getPhones(): List<PhoneResponseItem>{
        try {
            return service.getPhoneData()
        }catch (cause: Throwable){
            throw ErrorMessage("Data Gagal Diload", cause)
        }
    }
}

class ErrorMessage(message: String, cause: Throwable): Throwable(message, cause)