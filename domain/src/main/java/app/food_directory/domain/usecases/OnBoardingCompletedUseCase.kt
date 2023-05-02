

package app.food_directory.domain.usecases

import app.food_directory.inject.IoDispatcher
import app.food_directory.data.pref.PreferencesKeys
import app.food_directory.data.pref.repository.DataStoreOperations
import app.food_directory.domain.FlowUseCase
import app.food_directory.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OnBoardingCompletedUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreOperations,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, Boolean>(dispatcher) {
    override fun execute(parameters: Unit): Flow<Result<Boolean>> =
        dataStoreRepository.read(PreferencesKeys.onBoardingCompletedKey)
}
