package app.food_directory.search.vm

import app.food_directory.base.vm.MviViewModel

internal sealed interface ViewEvent : MviViewModel.MviEvent {
    data class SearchQuery(val query: String?, val cuisine: String?) : ViewEvent
}
