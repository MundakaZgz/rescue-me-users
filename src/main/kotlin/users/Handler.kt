package users

import arrow.core.Either
import arrow.core.getOrHandle
import core.AppException
import core.Reader
import core.users.Context
import core.users.bindGet
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/users")
class Handler(private val context: Context) {

    @GetMapping("{uuid}")
    suspend fun getJediByUUID(@PathVariable uuid: String) = handle { bindGet(uuid) }

    private suspend fun <A> handle(block: suspend () -> Reader<Context, Either<AppException, A>>) =
        block().provide(context).getOrHandle { throw it }
}