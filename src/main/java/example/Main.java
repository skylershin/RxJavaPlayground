package example;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

public class Main {
    public static void main(String[] args) {
//        CreateObservable createObservable = new CreateObservable();
//        createObservable.setValue("value");
//        String[] values = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
//        createObservable.setValues(values);
//
//        // Test the difference between just() and fromCallable()
//        Observable<String> just = createObservable.justValue();
//        Observable<String> fromCallable = createObservable.fromCallableValue();
//        fromCallable
//                .doOnNext(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        System.out.println("Observable fromCallable()");
//                        System.out.println("Current Thread: " + Thread.currentThread());
//                    }
//                })
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        System.out.println("subscribe: " + s);
//                    }
//                });
//        just
//                .doOnNext(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        System.out.println("Observable just()");
//                        System.out.println("Current Thread: " + Thread.currentThread());
//                    }
//                })
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        System.out.println("subscribe: " + s);
//                    }
//                });
//
//
//        CreateSubject createSubject = new CreateSubject();
//
//        createSubject.emitAsync();
//        createSubject.emitBehavior();
//        createSubject.emitPublish();
//        createSubject.emitReplay();

//        ConditionalObservable conditionalObservable = new ConditionalObservable();
//        conditionalObservable.amb();
//        conditionalObservable.defaultIfEmpty();
//        conditionalObservable.skipUntil();

        FilterObservable filterObservable = new FilterObservable();
        filterObservable.skipFirstAndDebounce();
    }
}