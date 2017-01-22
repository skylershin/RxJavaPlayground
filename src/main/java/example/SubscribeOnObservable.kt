package example

import rx.Observable
import rx.Scheduler
import rx.schedulers.Schedulers


/**
 * Created by MunkyuShin on 1/22/17.
 */
class SubscribeOnObservable {
    fun multipleSubscribe() {
        log("Starting")
        val obs = Observable.create<String> { subscriber ->
            log("Subscribed")
            subscriber.onNext("A")
            subscriber.onNext("B")
            subscriber.onCompleted()
        }
        log("Created")
        obs.subscribeOn(Schedulers.io())
                .doOnNext{x -> log(x)}
                .map { x -> x + '1' }
                .doOnNext{x -> log(x)}
//                .subscribeOn(Schedulers.io())
                .map { x -> x + '2' }
                .doOnNext{x -> log(x)}
                .subscribe { x -> log("Got" + x) }

    }

    private fun log(message: String) {
       println(
               Thread.currentThread().name + "\t| " + message
       )
    }
}

