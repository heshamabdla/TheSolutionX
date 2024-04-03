package am.leon.solutionx.common.di

import am.leon.solutionx.BuildConfig
import am.leon.solutionx.android.helpers.logging.getClassLogger
import am.leon.solutionx.common.data.repository.remote.ApiService
import am.leon.solutionx.common.data.repository.remote.RetrofitRestApiNetworkProvider
import am.leon.solutionx.common.domain.repository.remote.IRestApiNetworkProvider
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.UUID
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkDI {

    @Provides
    @Singleton
    fun provideCache(): Cache =
        Cache(File(System.getProperty("java.io.tmpdir"), UUID.randomUUID().toString()), 1024)

    @Provides
    fun provideNetworkProvider(apiService: ApiService): IRestApiNetworkProvider {
        return RetrofitRestApiNetworkProvider(apiService)
    }


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient.Builder): Retrofit {
        val gson = GsonBuilder().create()

        return Retrofit.Builder()
            .client(okHttpClient.build())
            .baseUrl("https://dev.api.altashirat.solutionplus.net/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache): OkHttpClient.Builder {
        return OkHttpClient().newBuilder().apply {
            cache(cache)
            connectTimeout(30L, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            connectionPool(
                ConnectionPool(30L.toInt(), 500000, TimeUnit.MILLISECONDS)
            )
            readTimeout(30L, TimeUnit.SECONDS)
            writeTimeout(30L, TimeUnit.SECONDS)
        }
    }

}