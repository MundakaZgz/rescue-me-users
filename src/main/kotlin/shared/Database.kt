package shared

sealed interface HasLive {
    interface InMemory {
        val oneProp: String
    }
}