package com.example.aplikasiprofilesekolah.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasiprofilesekolah.R
import com.example.aplikasiprofilesekolah.model.ItemRV

class GaleriItemListAdapter: RecyclerView.Adapter<GaleriItemListVH>() {
    private var listItem = arrayListOf<ItemRV>()

    fun addData(items: List<ItemRV>) {
        listItem.clear()
        listItem.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GaleriItemListVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_galeri, parent, false)
        return GaleriItemListVH(view)
    }

    override fun onBindViewHolder(holder: GaleriItemListVH, position: Int) {
        val data = listItem[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listItem.size
}