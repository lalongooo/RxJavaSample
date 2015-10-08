package com.lalongooo.rxjavasample;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by lalongooo on 07/10/15.
 */
public class MainClass {
    public static void main(String[] args) {
        System.out.println("Hello world from System.out!");

        /**
         * First sample, taking the verbose route
         */
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> sub) {
                        sub.onNext("Hello, world from RxJava!");
                        sub.onCompleted();
                    }
                }
        );

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) { System.out.println(s); }

            @Override
            public void onCompleted() { }

            @Override
            public void onError(Throwable e) { }
        };

        Subscriber<String> mySecondSubscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) { System.out.println(s + " - @lalongooo"); }

            @Override
            public void onCompleted() { }

            @Override
            pugit stblic void onError(Throwable e) { }
        };

        myObservable.subscribe(mySubscriber);
        myObservable.subscribe(mySecondSubscriber);


        /**
         * Second example, using "shortcuts"
         */
        Observable<String> myObservable1 =
                Observable.just("Hello world from Observable shortcuts!");

        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        };
        myObservable1.subscribe(onNextAction);

        /**
         * Third example, removing variables
         */
        Observable.just("Hello, world after removing variables!!")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });

        /**
         * Fourth example, using lambda
         */
        Observable.just("Hello, world using lambda expressions!!")
                .subscribeOn(Schedulers.io())
                .subscribe(s -> System.out.println(s));


    }
}
