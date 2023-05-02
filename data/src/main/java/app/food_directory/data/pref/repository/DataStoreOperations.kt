

package app.food_directory.data.pref.repository

import androidx.datastore.preferences.core.Preferences
import app.food_directory.result.Result
import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {
    suspend fun save(key: Preferences.Key<Boolean>, value: Boolean)
    fun read(key: Preferences.Key<Boolean>): Flow<Result<Boolean>>
}
