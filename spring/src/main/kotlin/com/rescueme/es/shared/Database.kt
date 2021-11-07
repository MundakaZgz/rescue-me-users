package com.rescueme.es.shared

sealed interface HasLive {
    interface InMemory {
        val oneProp: String
    }
}