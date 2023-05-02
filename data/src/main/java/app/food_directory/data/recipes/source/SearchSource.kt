

package app.food_directory.data.recipes.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import app.food_directory.data.recipes.remote.RecipesDataSource
import com.elbehiry.model.RecipesItem
import com.elbehiry.model.toUiModel
import javax.inject.Inject

private const val INITIAL_INDEX_PAGE = 1

class SearchSource @Inject constructor(
    private val recipesDataSource: RecipesDataSource,
    private val query: String?,
    private val cuisine: String?
) : PagingSource<Int, RecipesItem>() {

    @Suppress("TooGenericExceptionCaught")
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RecipesItem> {
        return try {
            val page = params.key ?: INITIAL_INDEX_PAGE
            val searchItem = recipesDataSource.searchRecipes(
                offset = page,
                query = query,
                cuisine = cuisine
            )
            LoadResult.Page(
                data = searchItem.results.map {
                    it.toUiModel() },
                prevKey = if (page == INITIAL_INDEX_PAGE) null else page - 1,
                nextKey = if (searchItem.results.isEmpty()) null else page.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, RecipesItem>): Int? {
        return null
    }
}
