package com.ebookfrenzy.dogproj_1.network

import com.squareup.moshi.Json

data class DogPhotoResponseImageObject(
    @Json(name = "message")
    val imageUrl: String
)
