package com.project.mytemplate.domine.models



data class ProductsResponseModel(
    val totalPages: Int,
    val number: Int,
    val recordsTotal: Int,
    val recordsFiltered: Int,
    val products: List<ProductModel>
)

data class ProductModel(
    val images: List<ImageModel>,
    val finalPrice: String,
    val descriptionName: String,
    val description: String,
    val quantity: Int,
    val manufacturerName: String,
    val model: String,
    val version: String,
    val year: String
)

data class ImageModel(
    val imageUrl: String
)