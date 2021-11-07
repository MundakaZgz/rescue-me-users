package com.rescueme.es.shared

import com.resueme.es.core.shared.define.Logger

object LiveLogger : Logger {
    override fun log(string: String) {
        println()
    }

    override fun error(string: String) {
        println()
    }

    override fun warn(string: String) {
        println()
    }
}