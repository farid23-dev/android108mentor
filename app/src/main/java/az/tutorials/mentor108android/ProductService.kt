package az.tutorials.mentor108android

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductService {
    @GET("products")
    suspend fun getProducts(@Query("limit") limit: Int, @Query("skip") skip: Int): Response<PaginatedProductResponse>
}