package com.example.performate.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.performate.R
import com.example.performate.data.model.PhoneResponseItem
import com.example.performate.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailData = intent?.getParcelableExtra<PhoneResponseItem>(DETAIL_DATA)

        binding.apply {
            txtOrderId.text = getString(R.string.order_id_detail, detailData?.orderNomor?.toString())
            txtTanggal.text = getString(R.string.tanggal_order, detailData?.orderTanggal)
            txtJenis.text = getString(R.string.jenis_hp, detailData?.jenisHandphone)
            txtName.text = getString(R.string.nama_cutomer, detailData?.name)

            if (detailData!!.waitingList){
                binding.imgWaiting.visibility = View.VISIBLE
            }

            if (detailData.identifikasiKerusakan){
                binding.imgCekKerusakan.visibility = View.VISIBLE
            }

            if (detailData.identifikasiKerusakanLainnya){
                binding.imgCekKerusakanLain.visibility = View.VISIBLE
            }

            if (detailData.pemasanganSparepart){
                binding.imgPemasanganSparepart.visibility = View.VISIBLE
            }

            if (detailData.finishing){
                binding.imgFinishing.visibility = View.VISIBLE
            }

            if (detailData.selesai){
                binding.imgDone.visibility = View.VISIBLE
            }
        }
    }

    companion object{
        const val DETAIL_DATA = "detail_data"
    }
}