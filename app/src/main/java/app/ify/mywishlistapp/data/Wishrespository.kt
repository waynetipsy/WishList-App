package app.ify.mywishlistapp.data

import kotlinx.coroutines.flow.Flow

class Wishrespository(private val wishDao: WishDao) {

    suspend fun addWish(wish: Wish){
        wishDao.addWish(wish)
    }

    fun getWishes() : Flow<List<Wish>> = wishDao.getAllWishes()

    fun getWishById(id: Long) :Flow<Wish> {
        return wishDao.getAllWisheById(id)
    }

   suspend fun updateAWish(wish: Wish) {
        wishDao.updateAWish(wish)
    }

    suspend fun deleteAWish(wish: Wish) {
        wishDao.deleteAWish(wish)
    }
}