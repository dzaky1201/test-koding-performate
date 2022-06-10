package com.example.performate.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhoneResponseItem(
    @SerializedName("biaya")
    val biaya: Int,
    @SerializedName("finishing")
    val finishing: Boolean,
    @SerializedName("identifikasi_kerusakan")
    val identifikasiKerusakan: Boolean,
    @SerializedName("identifikasi_kerusakan_lainnya")
    val identifikasiKerusakanLainnya: Boolean,
    @SerializedName("jenis_handphone")
    val jenisHandphone: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nomor_hp")
    val nomorHp: Long,
    @SerializedName("order_nomor")
    val orderNomor: Int,
    @SerializedName("order_tanggal")
    val orderTanggal: String,
    @SerializedName("pemasangan_sparepart")
    val pemasanganSparepart: Boolean,
    @SerializedName("selesai")
    val selesai: Boolean,
    @SerializedName("waiting_list")
    val waitingList: Boolean
): Parcelable