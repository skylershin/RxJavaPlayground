package example

import rx.Observable
import rx.functions.Action1
import java.util.concurrent.TimeUnit

/**
 * Created by MunkyuShin on 8/23/16.
 */
class FilterObservable {

    val items = arrayOf("one", "two", "three", "four", "five", "six", "seven", "eight")

    fun skipFirstAndDebounce() {
        val listObsevable = Observable.from(items);
        Observable.concat(listObsevable.first(), listObsevable.skip(1).debounce(1, TimeUnit.SECONDS))
                .subscribe({ item -> println(item) })
    }

}
