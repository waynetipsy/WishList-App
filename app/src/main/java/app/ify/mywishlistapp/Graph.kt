package app.ify.mywishlistapp

import app.ify.mywishlistapp.data.WishDatabase
import app.ify.mywishlistapp.data.Wishrespository

object Graph {
     lateinit var database: WishDatabase

     val wishrespository by lazy {
         Wishrespository(wishDao = database.wishDao())
     }


}