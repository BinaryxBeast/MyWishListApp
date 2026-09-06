package com.example.mywishlist.Data

import androidx.room.Entity
import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao: WishDao) {
    suspend fun addAWish(wish: Wish){
        wishDao.addAWish(wish)
    }
    suspend fun getWishes(): Flow<List<Wish>> = wishDao.getAllWishes()
     fun getAWishbyId(id: Long): Flow<Wish> {
        return wishDao.getAWishById(id)
    }
    suspend fun updateAWish(wish: Wish){
        wishDao.updateAWish(wish)
    }
    suspend fun deleteAWish(wishEntity: Wish){
        wishDao.deleteAWish(wishEntity)
    }
}