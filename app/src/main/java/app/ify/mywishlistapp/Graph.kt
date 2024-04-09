package app.ify.mywishlistapp

import android.content.Context
import androidx.room.Room
import app.ify.mywishlistapp.data.WishDatabase
import app.ify.mywishlistapp.data.Wishrespository

object Graph {
     lateinit var database: WishDatabase

     val wishrespository by lazy {
         Wishrespository(wishDao = database.wishDao())
     }

   fun provide(context: Context){
       database = Room.databaseBuilder(context, WishDatabase::class.java, "wishList.db").build()
   }
}