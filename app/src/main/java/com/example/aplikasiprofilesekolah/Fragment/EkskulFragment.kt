package com.example.aplikasiprofilesekolah.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplikasiprofilesekolah.R
import com.example.aplikasiprofilesekolah.model.ItemRV
import com.example.aplikasiprofilesekolah.recyclerview.GaleriItemListAdapter
import com.example.aplikasiprofilesekolah.retrofit.RetrofitInterfice
import com.example.aplikasiprofilesekolah.retrofit.RetrofitService
import kotlinx.android.synthetic.main.fragment_galeri.view.*
import kotlinx.coroutines.launch

class EkskulFragment : Fragment() {

    private lateinit var adapter: GaleriItemListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflate view yang akan digunakan, dalam hal ini fragment_galeri
        val view = inflater.inflate(R.layout.fragment_ekskul, container, false)
        // buat adapter untuk recyclerview
        adapter = GaleriItemListAdapter()
        // atur recyclerview rv_galeri
        view.RV_galeri.adapter = adapter
        view.RV_galeri.setHasFixedSize(true)
        view.RV_galeri.layoutManager = LinearLayoutManager(view.context)
        // pengaturan recyclerview selesai
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // buat variabel untuk membuat retrofitService
        val retrofitService = RetrofitService.buildService(RetrofitInterfice::class.java)
        // pada fragment kita gunakan viewLifecyclerOwner untuk menjalankan fungsi suspend / asynchronous
        viewLifecycleOwner.lifecycleScope.launch {
            // jalankan fungsi getDataGaleri yang berjalan secara asynchronous / di background
            val request = retrofitService.getDataGaleri()
            if (request.isSuccessful) { // jika request sukses
                val dataEkskul = request.body() as List<ItemRV>
                adapter.addData(dataEkskul)
                adapter.notifyDataSetChanged()
            }
        }
    }

}