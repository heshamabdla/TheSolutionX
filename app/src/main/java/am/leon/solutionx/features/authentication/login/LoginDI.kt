package am.leon.solutionx.features.authentication.login

import am.leon.solutionx.common.data.repository.local.crypto.CryptoDataImp
import am.leon.solutionx.common.domain.repository.local.crypto.ICryptoData
import am.leon.solutionx.common.domain.repository.local.keyValue.IStorageKeyValue
import am.leon.solutionx.common.domain.repository.remote.IRestApiNetworkProvider
import am.leon.solutionx.features.authentication.login.data.repository.LoginRepository
import am.leon.solutionx.features.authentication.login.data.repository.local.LoginLocalDS
import am.leon.solutionx.features.authentication.login.data.repository.remote.LoginRemoteDS
import am.leon.solutionx.features.authentication.login.domain.usecases.LoginWithPhoneUC
import am.leon.solutionx.features.authentication.login.domain.repository.ILoginRepository
import am.leon.solutionx.features.authentication.login.domain.repository.local.ILoginLocalDS
import am.leon.solutionx.features.authentication.login.domain.repository.remote.ILoginRemoteDS
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal object LoginDI {

    @Provides
    fun provideRemoteDS(networkProvider: IRestApiNetworkProvider): ILoginRemoteDS =
        LoginRemoteDS(networkProvider)

    @Provides
    fun provideCryptoData(): ICryptoData = CryptoDataImp()
    @Provides
    fun provideLocalDS(storageKeyValue: IStorageKeyValue,
                       cryptoData: ICryptoData
    ): ILoginLocalDS =
        LoginLocalDS(storageKeyValue,cryptoData)


    @Provides
    fun provideRepository(remoteDS: ILoginRemoteDS, localDS: ILoginLocalDS): ILoginRepository =
        LoginRepository(remoteDS, localDS)

    @Provides
    fun provideLoginWithEmailUC(repository: ILoginRepository): LoginWithPhoneUC =
        LoginWithPhoneUC(repository)
}