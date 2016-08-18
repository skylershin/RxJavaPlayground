package example;

import rx.Observable;
import rx.functions.Func0;

/**
 * Created by MunkyuShin on 4/13/16.
 */
public class CreateObservable {
    String value;
    String[] values;

    public void setValue(String value) {
        this.value = value;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    /**
     * fromCallable returns just single value.
     *
     * @return
     */
    Observable<String> fromCallableValue() {
        return Observable.fromCallable(new Func0<String>() {
            @Override
            public String call() {
                return value;
            }
        });
    }

    Observable<String[]> deferValues() {
        return Observable.defer(new Func0<Observable<String[]>>() {
            @Override
            public Observable<String[]> call() {
                return Observable.just(values);
            }
        });
    }

    Observable<String> justValue() {
        return Observable.just(value);
    }
}
