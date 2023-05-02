

package app.food_directory.domain.usecases

import app.food_directory.data.pref.PreferencesKeys
import app.food_directory.data.pref.repository.DataStoreOperations
import app.food_directory.domain.SuspendUseCase
import app.food_directory.inject.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class OnBoardingCompleteActionSuspendUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreOperations,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : SuspendUseCase<Boolean, Unit>(dispatcher) {
    override suspend fun execute(parameters: Boolean) =
        dataStoreRepository.save(PreferencesKeys.onBoardingCompletedKey, true)
}
