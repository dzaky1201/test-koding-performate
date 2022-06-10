package com.example.performate.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.performate.R
import com.example.performate.data.model.PhoneResponseItem
import com.example.performate.databinding.PhoneItemBinding
import java.text.SimpleDateFormat
import java.util.*

class MainAdapter(private val selectedItem: (PhoneResponseItem) -> Unit) :
    ListAdapter<PhoneResponseItem, MainAdapter.ViewHolder>(DiffCallBack()) {

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = PhoneItemBinding.bind(view)
        fun bind(phone: PhoneResponseItem) {
            binding.apply {
                txtOrderId.text = view.context.getString(R.string.order_id, phone.orderNomor.toString())
                txtOrderName.text = phone.name
                txtHarga.text = view.context.getString(R.string.harga, phone.biaya)
                binding.root.setOnClickListener {
                    selectedItem(phone)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.phone_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }
}

class DiffCallBack : DiffUtil.ItemCallback<PhoneResponseItem>() {
    override fun areItemsTheSame(oldItem: PhoneResponseItem, newItem: PhoneResponseItem): Boolean {
        return oldItem.orderNomor == newItem.orderNomor
    }

    override fun areContentsTheSame(
        oldItem: PhoneResponseItem,
        newItem: PhoneResponseItem
    ): Boolean {
        return oldItem == newItem
    }

}