package example

import rx.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by MunkyuShin on 1/25/17.
 */
class FlowControl {
    fun sample() {
        val startTime = System.currentTimeMillis()
        Observable
                .interval(7, TimeUnit.MILLISECONDS)
                .timestamp()
                .sample(1, TimeUnit.SECONDS)
                .map { ts ->  "${ts.timestampMillis - startTime}ms: " + ts.value }
                .take(5)
                .subscribe(::println)
    }

    fun complexSample() {
        val names = Observable.just("Mary", "Patricia", "Linda",
                "Barbara", "Elizabeth", "Jennifer", "Maria",
                "Susan", "Margaret", "Dorothy")

        val absoluteDelayMills: Observable<Long> = Observable.just(100, 600, 900,
                1100,
                3300, 3400, 3500, 3600,
                4400, 4800)

        val delayedNames = names
                .zipWith(absoluteDelayMills, {n, d ->
                    Observable.just(n)
                            .delay(d, TimeUnit.MILLISECONDS)
                })
                .flatMap { o -> o }

        delayedNames
                .sample(1, TimeUnit.SECONDS)
                .subscribe (::println)
    }
}
