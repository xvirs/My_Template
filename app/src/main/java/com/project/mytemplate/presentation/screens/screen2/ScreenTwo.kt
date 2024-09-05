package com.project.mytemplate.presentation.screens.screen2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Card
//import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.project.mytemplate.domine.models.ProductModel
import com.project.mytemplate.presentation.components.utils.Loading
import com.project.mytemplate.presentation.components.utils.ShimmerAnimation
import org.koin.androidx.compose.getViewModel
import kotlin.jvm.Throws

@Composable
fun ScreenTwo(
    viewModel: ScreenTwoViewModel = getViewModel()
){


    val token = viewModel.tokenString.collectAsState(initial = "Vacio")
    val isLoading = viewModel.isLoading.collectAsState(initial = false)
    val listProduct = viewModel.listProducts.collectAsState(initial = emptyList())

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center ){
        Column {
            Button(
                onClick = {
                    throw RuntimeException("Error de prueba")
                }
            ) {
                Text(text = "Tocar")
            }
            if(isLoading.value){
                Loading()
            } else {
                ListGrid(listProduct.value)
            }
        }

    }

}

@Composable
fun ListGrid(listProduct: List<ProductModel>){
    LazyVerticalGrid(GridCells.Fixed(2)) {
        listProduct.forEach {
            item {
                ItemProduct(it)
            }
        }
    }
}


@Composable
fun ItemProduct(product: ProductModel){
    Card(
        modifier = Modifier.height(150.dp).padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                modifier = Modifier
                    .height(100.dp)
            ) {
                ShimmerAnimation(modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(8.dp))
                )
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = product.images[0].imageUrl,
                    contentDescription = "Portada Product"
                )
            }

            Text(text = product.descriptionName)
            Text(text = "$ ${product.finalPrice}")
        }
    }
}