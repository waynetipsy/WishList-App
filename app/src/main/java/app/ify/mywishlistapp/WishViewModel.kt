package app.ify.mywishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.ify.mywishlistapp.data.Wish
import app.ify.mywishlistapp.data.Wishrespository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishrespository: Wishrespository
): ViewModel(
) {
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChanged(newString: String){
        wishTitleState = newString
    }

    fun onWishDescriptionChanged(newString: String) {
        wishDescriptionState = newString
    }


   lateinit var getAllWishes: Flow<List<Wish>>

   init {
       viewModelScope.launch {
           getAllWishes = wishrespository.getWishes()
       }
   }
    fun addWish(wish: Wish){
      viewModelScope.launch (Dispatchers.IO){
          wishrespository.addWish(wish = wish)
      }
    }

    fun getWishById(id:Long):Flow<Wish> {
        return wishrespository.getWishById(id)
    }

    fun updateWish(wish: Wish){
        viewModelScope.launch (Dispatchers.IO){
            wishrespository.updateAWish(wish = wish)
        }
    }
    fun deleteWish(wish: Wish){
        viewModelScope.launch (Dispatchers.IO){
            wishrespository.deleteAWish(wish = wish)
        }
    }
}