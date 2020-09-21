package com.example.aplikasiprofilesekolah.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aplikasiprofilesekolah.model.ItemRV
import kotlinx.android.synthetic.main.list_galeri.view.*

class GaleriItemListVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: ItemRV) {
        itemView.run {
            txt_title.text = item.title
            txt_description.text = item.description
            Glide.with(this).load(item.urlGambar).into(img_item_galeri)
        }
    }
}