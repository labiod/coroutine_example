package timeout

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("I'm sleeping $i")
            delay(500L)
        }
    }
    delay(2300L)
    println("main: I'm tired of waiting")
    //job.cancel()
    //job.join()
    job.cancelAndJoin()
    println("main: Now I can quit")
}