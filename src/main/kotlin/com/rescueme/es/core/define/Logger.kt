package com.rescueme.es.core.define

interface Logger : Dependency {
    fun log(string: String)

    fun error(string: String)

    fun warn(string: String)
}