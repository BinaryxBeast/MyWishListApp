package com.example.mywishlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywishlist.Data.Wish
import com.example.mywishlist.Data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository: WishRepository
): ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChanged(newTitle: String) {
        wishTitleState = newTitle
    }

    fun onWishDescriptionChanged(newDescription: String) {
        wishDescriptionState = newDescription
    }

    lateinit var getAllWishes: Flow<List<Wish>>
    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getWishes()
        }
    }

    fun getAWishById(id: Long): Flow<Wish> {
        return wishRepository.getAWishbyId(id)
    }

    fun addWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addAWish(wish = wish)
        }
    }

    fun updateWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateAWish(wish = wish)
        }
    }
}
