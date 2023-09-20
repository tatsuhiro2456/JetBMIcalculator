package com.example.jetbmicalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import kotlin.math.pow
import kotlin.math.roundToInt

class MainViewModel : ViewModel() {
    var height by mutableStateOf("")
    var weight by mutableStateOf("")

    //0fでフロート型
    var bmi by mutableStateOf(0f)

    //BMI = (体重)/(身長m)**2
    fun calculateBMI(){
        val heightNumber = height.toFloatOrNull()?.div(100) ?:0f
        val weightNumber = weight.toFloatOrNull() ?:0f

        //powは指数
        bmi = if(heightNumber > 0f && weightNumber >0){
            (weightNumber / heightNumber.pow(2) * 10).roundToInt() / 10f
        } else 0f
    }
}