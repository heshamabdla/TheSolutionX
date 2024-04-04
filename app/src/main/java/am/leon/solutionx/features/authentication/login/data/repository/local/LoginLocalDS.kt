package am.leon.solutionx.features.authentication.login.data.repository.local

import am.leon.solutionx.android.extentions.toJson
import am.leon.solutionx.common.data.repository.local.keyValue.StorageKeyEnum
import am.leon.solutionx.common.domain.repository.local.ICryptoData
import am.leon.solutionx.common.domain.repository.local.keyValue.IStorageKeyValue
import am.leon.solutionx.features.authentication.login.data.models.entity.LoginEntity
import am.leon.solutionx.features.authentication.login.data.models.entity.UserEntity
import am.leon.solutionx.features.authentication.login.domain.repository.local.ILoginLocalDS
import com.google.gson.Gson
import java.util.Base64

internal class LoginLocalDS(private val storageKV: IStorageKeyValue,
    private val iCryptoData: ICryptoData) : ILoginLocalDS {


    override suspend fun saveLogin(login: LoginEntity) {

        val byteToken= login.accessToken.toByteArray()
        val encryptedText= Base64.getEncoder().encodeToString(iCryptoData.encrypt(byteToken))
        storageKV.saveEntry(StorageKeyEnum.ACCESS_TOKEN, encryptedText)

        val byteUserByte= login.user.toJson().toByteArray()
        val encryptedUser= Base64.getEncoder().encodeToString(iCryptoData.encrypt(byteUserByte))
        storageKV.saveEntry(StorageKeyEnum.USER, Gson().toJson( encryptedUser))
    }

    override suspend fun getUser(): UserEntity {

       val json= iCryptoData.decrypt(Base64.getDecoder().
        decode(storageKV.readEntry(StorageKeyEnum.USER, "")))?.decodeToString()

        return Gson().fromJson(json, UserEntity::class.java)
    }

    override suspend fun getAccessToken(): String {
       val token= iCryptoData.decrypt(Base64.getDecoder().
        decode(storageKV.readEntry(StorageKeyEnum.ACCESS_TOKEN, "")))?.decodeToString()

        return token.toString()
    }
}