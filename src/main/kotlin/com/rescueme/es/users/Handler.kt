package com.rescueme.es.users

import arrow.core.Either
import arrow.core.getOrHandle
import com.rescueme.es.shared.core.AppException
import com.rescueme.es.users.core.Context
import com.rescueme.es.users.core.bindGet
import org.springframework.stereotype.Indexed
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Indexed
@ResponseBody
@RequestMapping("/users")
class Handler(private val context: Context) {

    @GetMapping("{uuid}")
    suspend fun getUserByUUID(@PathVariable uuid: String) =
        handle { context.bindGet(uuid) }

    private suspend fun <A> handle(block: suspend () -> Either<AppException, A>) =
        block().getOrHandle { throw it }
}