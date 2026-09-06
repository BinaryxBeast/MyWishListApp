package com.example.mywishlist.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "wish-item")
    val title: String = "",
    @ColumnInfo(name = "wish-desc")
    val description: String = ""
)
object DummyWish{
    val wishList = listOf(
        Wish(title = "Google watch 2", description = "An Android Watch")
    )
}