package com.han.inhauniversityphonebook.model

data class NumberModel(
    val name: String,
    val number: String,
    val call: String,
    val location: String
){
    constructor():this("","","", "")
}
