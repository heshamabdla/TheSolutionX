package am.leon.solutionx.security

import am.leon.solutionx.common.data.repository.local.crypto.CryptoDataImp
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EncryptionTest {

    private val cryptoDataImp=CryptoDataImp()
    @Test
    fun testEncryptionAndDecryption() {
        val text = "testEncryption"

        val encryptedText = cryptoDataImp.encrypt(text.toByteArray())
        val decryptedText = cryptoDataImp.decrypt(encryptedText)

        Assert.assertEquals(text, decryptedText)
    }

}