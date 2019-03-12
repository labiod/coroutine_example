package basic

import kotlinx.coroutines.*

suspend fun main() {
//    basic.waitUsingJoin()
//    basic.waitUsingRunBlocking()
//    basic.createCoroutineScope()
//    basic.launchFromFunction()
//    basic.multiCoroutineLaunch()
    multiGlobalCoroutineScope()
}

suspend fun waitUsingJoin() {
    val job = GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
    job.join()
}

fun waitUsingRunBlocking() = runBlocking {
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
}

fun createCoroutineScope() = runBlocking {
    launch {
        delay(2000L)
        println("Task from runBlocking")
    }

    coroutineScope { // Create own coroutine scope
        launch {
            delay(3000L)
            println("Task from nested launch")
        }
        delay(1000L)
        println("Task from own coroutine scope")
    }
    println("Couroutine scope is over")
}

fun launchFromFunction() = runBlocking {
    launch {
        doWorld()
    }
    println("Hello,")
}

suspend fun doWorld() {
    delay(1000L)
    println("World")
}

fun multiCoroutineLaunch() = runBlocking {
    repeat(100_000) { // launch a lot of coroutines
        launch {
            delay(1000L)
            print(".")
        }
    }
}

suspend fun multiGlobalCoroutineScope() {
    GlobalScope.launch {
        repeat(1000) { i ->
            println("I'm sleeping $i")
            delay(500L)
        }
    }
    delay(1300L)
}
