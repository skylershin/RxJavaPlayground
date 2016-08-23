package example

import rx.Observable
import rx.functions.Action1
import rx.functions.Func3
import java.util.concurrent.TimeUnit

/**
 * Created by MunkyuShin on 8/23/16.
 */
class ConditionalObservable {

    val ambAction: Action1<Int> = Action1 { i ->
        println("amb ${i}")
    }

    /**
     * given two or more source Observables, emit all of the items from only the first of these Observables to emit an item or notification
     */
    fun amb() {
        val observable1 : Observable<Int> = Observable.from(arrayOf(20, 40, 60)).delay(5, TimeUnit.SECONDS)
        val observable2 = Observable.from(arrayOf(1, 2, 3))
        val observable3 = Observable.from(arrayOf(0, 0, 0)).delay(10, TimeUnit.SECONDS)

        Observable.amb(observable1, observable2, observable3)
                .subscribe(ambAction)
    }
}
