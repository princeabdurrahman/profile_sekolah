package com.example.aplikasiprofilesekolah.model

import com.squareup.moshi.Json

    data class ItemRV(
        @Json(name = "urlGambar")
        var urlGambar: String = "",
        @Json(name = "title")
        var title: String = "",
        @Json(name = "description")
        var description: String = "",
        var type: String = ""
    )
