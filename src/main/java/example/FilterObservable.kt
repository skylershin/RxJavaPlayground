package example

import rx.Observable
import rx.Scheduler
import rx.functions.Action1
import rx.functions.Func1
import java.util.concurrent.TimeUnit

/**
 * Created by MunkyuShin on 8/23/16.
 */
class FilterObservable {

    val items = arrayOf("one", "two", "three", "four", "five", "six", "seven", "eight")

    fun skipFirstAndDebounce() {
        val listObsevable = Observable.from(items)
        Observable.concat(listObsevable.first(), listObsevable.skip(1).debounce(1, TimeUnit.SECONDS))
                .subscribe({ item -> println(item) })
    }

    fun filter() {
        val listObservable = Observable.from(items)
        listObservable
                .filter { item -> item.length > 4 }
                .subscribe({ filteredItem -> println("Filtered item : ${filteredItem}")})
    }

    fun takeLast(count: Int) {
        val listObservable = Observable.from(items)
        listObservable
                .takeLast(count)
                .subscribe({ lastItem -> println(lastItem)})
    }

    /**
     * Complete 가 되면 마지막 해당 시간 전 중에 최대 count 만큼 나옴
     *
     * time: 0...500...1000...1500...2000...2500...3000
     * emit: 0...1.....2......3......4......5......6
     * takeLast:.....................X......X......X
     * param's time...[...........2seconds..........]
     *
     * 4 개를 받기로 했지만 마지막 1초 동안은 456 만 해당하므로 3개만 출력
     */
    fun takeLast(count: Int, time: Long, timeUnit: TimeUnit) {
        Observable.interval(500L, TimeUnit.MILLISECONDS)
                .take(7)
                .takeLast(count, time, timeUnit)
                .subscribe({item -> println(item)})
    }

}
