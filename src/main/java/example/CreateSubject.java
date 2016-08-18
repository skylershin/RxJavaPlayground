package example;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.ReplaySubject;

/**
 * Created by MunkyuShin on 4/13/16.
 */
public class CreateSubject {

    final PublishSubject<String> mPublishSubject = PublishSubject.create();
    final AsyncSubject<String> mAsyncSubject = AsyncSubject.create();
    // BehaviorSubject는 초기값 지정 가능.
    final BehaviorSubject<String> mBehaviorSubject = BehaviorSubject.create();
    final ReplaySubject<String> mReplaySubject = ReplaySubject.create();

    Action1<String> asyncObserver = new Action1<String>() {
        @Override
        public void call(String s) {
            System.out.println("AsyncSubject ");
            System.out.println("subscribe: " + s);
        }
    };

    /**
     * onComplete 가 불리기 바로 직전에 emit 된 아이템을 subscribe 한다
     */
    void emitAsync() {
        mAsyncSubject.onNext("one");
        mAsyncSubject.onNext("two");
        mAsyncSubject.onNext("three");
        mAsyncSubject.subscribe(asyncObserver);
        mAsyncSubject.onCompleted();
        mAsyncSubject.subscribe(asyncObserver);

    }

    Action1<String> behaviorObserver1 = new Action1<String>() {
        @Override
        public void call(String s) {
            System.out.println("BehaviorSubject 1 ");
            System.out.println("subscribe 1: " + s);
        }
    };

    Action1<String> behaviorObserver2 = new Action1<String>() {
        @Override
        public void call(String s) {
            System.out.println("BehaviorSubject 2  ");
            System.out.println("subscribe 2: " + s);
        }
    };

    void emitBehavior() {
        mBehaviorSubject.onNext("one");
        mBehaviorSubject.subscribe(behaviorObserver1);
        mBehaviorSubject.onNext("two");
        mBehaviorSubject.onNext("three");
        mBehaviorSubject.subscribe(behaviorObserver2);
        mBehaviorSubject.onNext("four");
        mBehaviorSubject.onNext("five");
        mBehaviorSubject.onCompleted();
    }

    Action1<String> replayObserver1 = new Action1<String>() {
        @Override
        public void call(String s) {
            System.out.println("ReplaySubject 1 ");
            System.out.println("subscribe 1: " + s);
        }
    };

    Action1<String> replayObserver2 = new Action1<String>() {
        @Override
        public void call(String s) {
            System.out.println("ReplaySubject 2  ");
            System.out.println("subscribe 2: " + s);
        }
    };

    Action1<String> replayObserver3 = new Action1<String>() {
        @Override
        public void call(String s) {
            System.out.println("ReplaySubject 3  ");
            System.out.println("subscribe 3: " + s);
        }
    };

    void emitReplay() {
        mReplaySubject.onNext("one");
        mReplaySubject.subscribe(replayObserver1);
        mReplaySubject.onNext("two");
        mReplaySubject.onNext("three");
        mReplaySubject.subscribe(replayObserver2);
        mReplaySubject.onNext("four");
        mReplaySubject.onNext("five");
        mReplaySubject.onCompleted();

        mReplaySubject.subscribe(replayObserver3);
    }

    Action1<String> publishObserver1 = new Action1<String>() {
        @Override
        public void call(String s) {
            System.out.println("PublishSubject 1 ");
            System.out.println("subscribe 1: " + s);
        }
    };

    Action1<String> publishObserver2 = new Action1<String>() {
        @Override
        public void call(String s) {
            System.out.println("PublishSubject 2  ");
            System.out.println("subscribe 2: " + s);
        }
    };

    /**
     * subscribe를 한 시점 부터 아이템을 받는다
     */
    void emitPublish() {
        mPublishSubject.onNext("one");
        mPublishSubject.subscribe(publishObserver1);
        mPublishSubject.onNext("two");
        mPublishSubject.onNext("three");
        mPublishSubject.subscribe(publishObserver2);
        mPublishSubject.onCompleted();
    }
}
