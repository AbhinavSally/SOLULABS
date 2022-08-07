package com.abhinav.solulabs.data.models.response

data class Data(
    val itemsPerPage: Int,
    val list: ArrayList<res>,
    val startIndex: Int,
    val totalItems: Int
)