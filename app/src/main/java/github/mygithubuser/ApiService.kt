package github.mygithubuser

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    @Headers("Authorization: token <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>")
    @GET("/search/users")
    fun getUser(
        @Path("users") users: String
    ): Call<GithubUserResponse>


}