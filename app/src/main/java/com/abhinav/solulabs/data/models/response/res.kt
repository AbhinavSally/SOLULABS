package com.abhinav.solulabs.data.models.response

data class res(
    val _id: String,
    val age: Int,
    val history: String,
    val isCoin: Boolean,
    val isGraded: Boolean,
    val isSold: Boolean,
    val name: String,
    val pictures: Pictures,
    val price: Int,
    val tags: List<String>,
    val year: Int
)