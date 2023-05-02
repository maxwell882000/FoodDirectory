

package com.elbehiry.shared.data.searchrestaurants

//import com.elbehiry.model.Response
//import com.elbehiry.model.VenuesResult
//import com.elbehiry.shared.data.remote.DelishApi
//import com.elbehiry.shared.data.restaurants.remote.ISearchRestaurantsDataSource
//import com.elbehiry.shared.data.restaurants.remote.SearchRestaurantsDataSource
//import com.elbehiry.test_shared.MainCoroutineRule
//import com.elbehiry.test_shared.SEARCH_ITEM
//import com.elbehiry.test_shared.VENUES_ITEMS
//import com.elbehiry.test_shared.runBlockingTest
//import com.github.javafaker.Faker
//import com.nhaarman.mockito_kotlin.any
//import com.nhaarman.mockito_kotlin.whenever
//import org.junit.Assert
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.Mock
//import org.mockito.junit.MockitoJUnitRunner
//
//@RunWith(MockitoJUnitRunner::class)
//class SearchDataSourceTest {
//
//    @get:Rule
//    var coroutineRule = MainCoroutineRule()
//    private lateinit var searchDataSource: ISearchRestaurantsDataSource
//
//    @Mock
//    private lateinit var api: DelishApi
//    private val faker by lazy {
//        Faker()
//    }
//
//    @Before
//    fun setup() {
//        searchDataSource = SearchRestaurantsDataSource(api)
//    }
//
//    @Test
//    fun `test search should be successful`() {
//        coroutineRule.runBlockingTest {
//            whenever(api.search(any(), any(), any(), any(), any(), any(), any())).thenReturn(
//                SEARCH_ITEM
//            )
//
//            val items = searchDataSource.search(
//                "${faker.address().latitude()},${faker.address().longitude()}",
//                faker.number().digits(3).toString(),
//                faker.number().digits(2).toInt(),
//                faker.number().digits(2).toInt()
//            )
//            Assert.assertEquals(items.response?.venues, VENUES_ITEMS)
//        }
//    }
//
//    @Test
//    fun `test search in case of empty response return empty venues`() {
//        coroutineRule.runBlockingTest {
//            whenever(api.search(any(), any(), any(), any(), any(), any(), any())).thenReturn(
//                VenuesResult(response = Response())
//            )
//            val items = searchDataSource.search(
//                "${faker.address().latitude()},${faker.address().longitude()}",
//                faker.number().digits(3).toString(),
//                faker.number().digits(2).toInt(),
//                faker.number().digits(2).toInt()
//            )
//            Assert.assertTrue(items.response?.venues?.isEmpty() ?: false)
//        }
//    }
//}
