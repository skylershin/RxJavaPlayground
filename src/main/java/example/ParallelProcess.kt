package example

import rx.Observable
import rx.schedulers.Schedulers.computation
import rx.schedulers.Schedulers
import java.util.*


/**
 * Created by munkyushin on 2/7/17.
 */
class ParallelProcess {
    fun useFlatMap() {
        val vals = Observable.range(1, 10)

        vals.flatMap({ `val` ->
            Observable.just(`val`)
                    .subscribeOn(Schedulers.computation())
                    .map({ i -> intenseCalculation(i) })
        }
        ).toList()
                .subscribe({ `val` ->
                    println("Subscriber received "
                            + `val` + " on "
                            + Thread.currentThread().name)
                })
    }

    fun intenseCalculation(i: Int): Int {
        try {
            println("Calculating " + i +
                    " on " + Thread.currentThread().name)
            val r = Random(1000)
            Thread.sleep(r.nextLong())
            return i
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        }

    }
}
