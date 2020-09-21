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
import kotlinx.android.synthetic.main.fragment_prestasi_.view.*
import kotlinx.coroutines.launch

class Presentasi_Fragment : Fragment() {

    private lateinit var adapter: GaleriItemListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_prestasi_, container, false)
        adapter = GaleriItemListAdapter()
        view.rv_prestasi.adapter = adapter
        view.rv_prestasi.setHasFixedSize(true)
        view.rv_prestasi.layoutManager = LinearLayoutManager(view.context)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retrofitService = RetrofitService.buildService(RetrofitInterfice::class.java)
        viewLifecycleOwner.lifecycleScope.launch {
            val request = retrofitService.getDataPrestasi()
            if (request.isSuccessful) {
                val dataPrestasi = request.body() as List<ItemRV>
                adapter.addData(dataPrestasi)
                adapter.notifyDataSetChanged()
            }
        }
    }
}