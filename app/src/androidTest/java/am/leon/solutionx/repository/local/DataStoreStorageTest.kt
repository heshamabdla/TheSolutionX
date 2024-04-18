package am.leon.solutionx.repository.local

import am.leon.solutionx.common.data.repository.local.keyValue.DataStoreStorageKeyValue
import am.leon.solutionx.common.data.repository.local.keyValue.StorageKeyEnum
import android.content.Context
import android.content.res.Resources.NotFoundException
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DataStoreStorageAndroidTest {
    private lateinit var dataStoreStorage: DataStoreStorageKeyValue
    lateinit var context: Context

    @Before
    fun setup() {
         context = ApplicationProvider.getApplicationContext()
        dataStoreStorage = DataStoreStorageKeyValue(context)
    }


    @Test
    fun saveAndGetTest() {
        runBlocking {

            val value = "valueTest"

            dataStoreStorage.saveEntry(StorageKeyEnum.ACCESS_TOKEN, value)
            val storedValue: String = dataStoreStorage.readEntry(StorageKeyEnum.ACCESS_TOKEN,"")
            assertEquals(value, storedValue)
        }
    }


    @Test
    fun saveAndGetUsingDifferentTypes() {
        runBlocking {
            val stringValue = "testValue"
            dataStoreStorage.saveEntry(StorageKeyEnum.ACCESS_TOKEN, stringValue)
            val storedStringValue: String = dataStoreStorage.readEntry(StorageKeyEnum.ACCESS_TOKEN,"")
            assertEquals(stringValue, storedStringValue)

            val intValue = 123
            dataStoreStorage.saveEntry(StorageKeyEnum.ACCESS_TOKEN, intValue)
            val storedIntValue: Int = dataStoreStorage.readEntry(StorageKeyEnum.ACCESS_TOKEN,0)
            assertEquals(storedIntValue, storedStringValue)

            val floatValue = 1.1
            dataStoreStorage.saveEntry(StorageKeyEnum.ACCESS_TOKEN, floatValue)
            val storedFloatValue: Float = dataStoreStorage.readEntry(StorageKeyEnum.ACCESS_TOKEN,0.0f)
            assertEquals(storedIntValue, storedStringValue)
        }
    }

    //    @Test(expected = Exception::class)
//    fun testSaveAndGetWithNotKey() {
//        runBlocking {
//            val Key = "Key"
//            dataStoreStorage.readEntry()
//        }
//    }



}