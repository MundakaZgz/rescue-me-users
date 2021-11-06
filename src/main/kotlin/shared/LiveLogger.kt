package shared

import core.define.Logger

object LiveLogger: Logger {
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