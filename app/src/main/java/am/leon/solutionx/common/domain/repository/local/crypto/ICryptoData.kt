package am.leon.solutionx.common.domain.repository.local.crypto

interface ICryptoData {
    fun encrypt(bytes: ByteArray): ByteArray
    fun decrypt(bytes: ByteArray): ByteArray?
}