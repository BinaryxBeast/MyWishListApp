package com.example.mywishlist.Data

data class Wish(
    val id: Long = 0L,
    val title: String = "",
    val description: String = ""
)
object DummyWish{
    val wishList = listOf(
        Wish(title = "Google watch 2", description = "An Android Watch")
    )
}