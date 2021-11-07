package com.resueme.es.core.shared.define

interface Logger : Dependency {
    fun log(string: String)

    fun error(string: String)

    fun warn(string: String)
}