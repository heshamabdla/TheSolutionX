package am.leon.solutionx.common.di

import am.leon.solutionx.common.data.repository.local.keyValue.DataStoreStorageKeyValue
import am.leon.solutionx.common.domain.repository.local.keyValue.IStorageKeyValue
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object StorageDI {
    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context): IStorageKeyValue =
        DataStoreStorageKeyValue(context)
}