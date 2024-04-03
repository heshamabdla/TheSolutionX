package am.leon.solutionx.common.data.repository.remote

import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ApiService {

    @POST("{pathUrl}")
    @JvmSuppressWildcards
    suspend fun post(
        @Path("pathUrl") pathUrl: String, @HeaderMap headers: Map<String, Any>,
        @QueryMap queryParams: Map<String, Any>, @Body requestBody: Any
    ): ResponseBody

}