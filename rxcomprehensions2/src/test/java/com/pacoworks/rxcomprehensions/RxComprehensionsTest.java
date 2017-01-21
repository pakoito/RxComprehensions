/*
 * Copyright (c) pakoito 2016
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pacoworks.rxcomprehensions;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.observers.TestObserver;

public class RxComprehensionsTest {

    @Test
    public void oneFM() {
        Assert.assertEquals(RxComprehensions.doFM(zero(1), one(true)).blockingFirst(), true);
    }

    @Test
    public void twoFM() {
        Assert.assertEquals(RxComprehensions.doFM(zero(2), one(true), two("result")).blockingFirst(), "result");
    }

    @Test
    public void threeFM() {
        Assert.assertEquals(RxComprehensions.doFM(zero(3), one(true), two("result"), three("other")).blockingFirst(), "other");
    }

    @Test
    public void fourFM() {
        Assert.assertEquals(RxComprehensions.doFM(zero(4), one(true), two("result"), three("other"), four("other".length())).blockingFirst(), new Long("other".length()));
    }

    @Test
    public void fiveFM() {
        Assert.assertEquals(RxComprehensions.doFM(zero(1), one(true), two("result"), three("other"), four("other".length()), five("other".length() < 5)).blockingFirst(), false);
    }

    @Test
    public void sixFM() {
        Assert.assertEquals(RxComprehensions.doFM(zero(1), one(true), two("result"), three("other"), four("other".length()), five("other".length() < 5), six(Boolean.toString(false))).blockingFirst(), "false");
    }

    @Test
    public void sevenFM() {
        Assert.assertEquals(RxComprehensions.doFM(zero(1), one(true), two("result"), three("other"), four("other".length()), five("other".length() < 5), six(Boolean.toString(false)), seven("true")).blockingFirst(), false);
    }

    @Test
    public void eightFM() {
        Assert.assertEquals(RxComprehensions.doFM(zero(1), one(true), two("result"), three("other"), four("other".length()), five("other".length() < 5), six(Boolean.toString(false)), seven("true"), eight(Long.class)).blockingFirst(), Long.class);
    }

    @Test
    public void nineFM() {
        final TestObserver<Object> observer = TestObserver.create();
        RxComprehensions.doFM(zero(1), one(true), two("result"), three("other"), four("other".length()), five("other".length() < 5), six(Boolean.toString(false)), seven("true"), eight(Long.class), this.<Long>nine()).subscribe(observer);
        observer.awaitTerminalEvent();
        observer.assertComplete();
        observer.assertNoErrors();
        observer.assertResult(1, true, "result", "other", (long) "other".length(), "other".length() < 5, Boolean.toString(false), false, Long.class);
    }

    @Test
    public void oneCM() {
        Assert.assertEquals(RxComprehensions.doCM(zero(1), one(true)).blockingFirst(), true);
    }

    @Test
    public void twoCM() {
        Assert.assertEquals(RxComprehensions.doCM(zero(2), one(true), two("result")).blockingFirst(), "result");
    }

    @Test
    public void threeCM() {
        Assert.assertEquals(RxComprehensions.doCM(zero(3), one(true), two("result"), three("other")).blockingFirst(), "other");
    }

    @Test
    public void fourCM() {
        Assert.assertEquals(RxComprehensions.doCM(zero(4), one(true), two("result"), three("other"), four("other".length())).blockingFirst(), new Long("other".length()));
    }

    @Test
    public void fiveCM() {
        Assert.assertEquals(RxComprehensions.doCM(zero(1), one(true), two("result"), three("other"), four("other".length()), five("other".length() < 5)).blockingFirst(), false);
    }

    @Test
    public void sixCM() {
        Assert.assertEquals(RxComprehensions.doCM(zero(1), one(true), two("result"), three("other"), four("other".length()), five("other".length() < 5), six(Boolean.toString(false))).blockingFirst(), "false");
    }

    @Test
    public void sevenCM() {
        Assert.assertEquals(RxComprehensions.doCM(zero(1), one(true), two("result"), three("other"), four("other".length()), five("other".length() < 5), six(Boolean.toString(false)), seven("true")).blockingFirst(), false);
    }

    @Test
    public void eightCM() {
        Assert.assertEquals(RxComprehensions.doCM(zero(1), one(true), two("result"), three("other"), four("other".length()), five("other".length() < 5), six(Boolean.toString(false)), seven("true"), eight(Long.class)).blockingFirst(), Long.class);
    }

    @Test
    public void nineCM() {
        final TestObserver<Object> observer = TestObserver.create();
        RxComprehensions.doCM(zero(1), one(true), two("result"), three("other"), four("other".length()), five("other".length() < 5), six(Boolean.toString(false)), seven("true"), eight(Long.class), this.<Long>nine()).subscribe(observer);
        observer.awaitTerminalEvent();
        observer.assertComplete();
        observer.assertNoErrors();
        observer.assertResult(1, true, "result", "other", (long) "other".length(), "other".length() < 5, Boolean.toString(false), false, Long.class);
    }

    @Test
    public void oneSM() {
        Assert.assertEquals(RxComprehensions.doSM(zero(1), one(true)).blockingFirst(), true);
    }

    @Test
    public void twoSM() {
        Assert.assertEquals(RxComprehensions.doSM(zero(2), one(true), two("result")).blockingFirst(), "result");
    }

    @Test
    public void threeSM() {
        Assert.assertEquals(RxComprehensions.doSM(zero(3), one(true), two("result"), three("other")).blockingFirst(), "other");
    }

    @Test
    public void fourSM() {
        Assert.assertEquals(RxComprehensions.doSM(zero(4), one(true), two("result"), three("other"), four("other".length())).blockingFirst(), new Long("other".length()));
    }

    @Test
    public void fiveSM() {
        Assert.assertEquals(RxComprehensions.doSM(zero(1), one(true), two("result"), three("other"), four("other".length()), five("other".length() < 5)).blockingFirst(), false);
    }

    @Test
    public void sixSM() {
        Assert.assertEquals(RxComprehensions.doSM(zero(1), one(true), two("result"), three("other"), four("other".length()), five("other".length() < 5), six(Boolean.toString(false))).blockingFirst(), "false");
    }

    @Test
    public void sevenSM() {
        Assert.assertEquals(RxComprehensions.doSM(zero(1), one(true), two("result"), three("other"), four("other".length()), five("other".length() < 5), six(Boolean.toString(false)), seven("true")).blockingFirst(), false);
    }

    @Test
    public void eightSM() {
        Assert.assertEquals(RxComprehensions.doSM(zero(1), one(true), two("result"), three("other"), four("other".length()), five("other".length() < 5), six(Boolean.toString(false)), seven("true"), eight(Long.class)).blockingFirst(), Long.class);
    }

    @Test
    public void nineSM() {
        final TestObserver<Object> observer = TestObserver.create();
        RxComprehensions.doSM(zero(1), one(true), two("result"), three("other"), four("other".length()), five("other".length() < 5), six(Boolean.toString(false)), seven("true"), eight(Long.class), this.<Long>nine()).subscribe(observer);
        observer.awaitTerminalEvent();
        observer.assertComplete();
        observer.assertNoErrors();
        observer.assertResult(1, true, "result", "other", (long) "other".length(), "other".length() < 5, Boolean.toString(false), false, Long.class);
    }

    @Test
    public void oneCo() {
        Assert.assertEquals((RxComprehensions.doCo(zero(0), intIncrementToString()).blockingFirst()), "1");
    }

    @Test
    public void twoCo() {
        Assert.assertEquals((long)RxComprehensions.doCo(zero(0), intIncrementToString(), stringToInt()).blockingFirst(), 1);
    }

    @Test
    public void threeCo() {
        Assert.assertEquals((RxComprehensions.doCo(zero(0), intIncrementToString(), stringToInt(), intIncrementToString()).blockingFirst()), "2");
    }

    @Test
    public void fourCo() {
        Assert.assertEquals((long)RxComprehensions.doCo(zero(0), intIncrementToString(), stringToInt(), intIncrementToString(), stringToInt()).blockingFirst(), 2);
    }

    @Test
    public void fiveCo() {
        Assert.assertEquals((RxComprehensions.doCo(zero(0), intIncrementToString(), stringToInt(), intIncrementToString(), stringToInt(), intIncrementToString()).blockingFirst()), "3");
    }

    @Test
    public void sixCo() {
        Assert.assertEquals((long)RxComprehensions.doCo(zero(0), intIncrementToString(), stringToInt(), intIncrementToString(), stringToInt(), intIncrementToString(), stringToInt()).blockingFirst(), 3);
    }

    @Test
    public void sevenCo() {
        Assert.assertEquals((RxComprehensions.doCo(zero(0), intIncrementToString(), stringToInt(), intIncrementToString(), stringToInt(), intIncrementToString(), stringToInt(), intIncrementToString()).blockingFirst()), "4");
    }

    @Test
    public void eightCo() {
        Assert.assertEquals((long)RxComprehensions.doCo(zero(0), intIncrementToString(), stringToInt(), intIncrementToString(), stringToInt(), intIncrementToString(), stringToInt(), intIncrementToString(), stringToInt()).blockingFirst(), 4);
    }

    @Test
    public void nineCo() {
        Assert.assertEquals((RxComprehensions.doCo(zero(0), intIncrementToString(), stringToInt(), intIncrementToString(), stringToInt(), intIncrementToString(), stringToInt(), intIncrementToString(), stringToInt(), intIncrementToString()).blockingFirst()), "5");
    }

    // region Helpers

    private Callable<Observable<Integer>> zero(final int i) {
        return new Callable<Observable<Integer>>() {
            @Override
            public Observable<Integer> call() {
                return Observable.just(i);
            }
        };
    }

    private Function<Integer, Observable<Boolean>> one(final boolean value) {
        return new Function<Integer, Observable<Boolean>>() {
            @Override
            public Observable<Boolean> apply(Integer integer) {
                return Observable.just(value);
            }
        };
    }

    private BiFunction<Integer, Boolean, Observable<String>> two(final String value) {
        return new BiFunction<Integer, Boolean, Observable<String>>() {
            @Override
            public Observable<String> apply(Integer integer, Boolean aBoolean) {
                return Observable.just(value);
            }
        };
    }

    private Function3<Integer, Boolean, String, Observable<String>> three(final String other) {
        return new Function3<Integer, Boolean, String, Observable<String>>() {
            @Override
            public Observable<String> apply(Integer integer, Boolean aBoolean, String s) {
                return Observable.just(other);
            }
        };
    }

    private Function4<Integer, Boolean, String, String, Observable<Long>> four(final long length) {
        return new Function4<Integer, Boolean, String, String, Observable<Long>>() {
            @Override
            public Observable<Long> apply(Integer integer, Boolean aBoolean, String s, String s2) {
                return Observable.just(length);
            }
        };
    }

    private Function5<Integer, Boolean, String, String, Long, Observable<Boolean>> five(final boolean b) {
        return new Function5<Integer, Boolean, String, String, Long, Observable<Boolean>>() {
            @Override
            public Observable<Boolean> apply(Integer integer, Boolean aBoolean, String s, String s2, Long aLong) {
                return Observable.just(b);
            }
        };
    }

    private Function6<Integer, Boolean, String, String, Long, Boolean, Observable<String>> six(final String string) {
        return new Function6<Integer, Boolean, String, String, Long, Boolean, Observable<String>>() {
            @Override
            public Observable<String> apply(Integer integer, Boolean aBoolean, String s, String s2, Long aLong, Boolean aBoolean2) {
                return Observable.just(string);
            }
        };
    }

    private Function7<Integer, Boolean, String, String, Long, Boolean, String, Observable<Boolean>> seven(final String parameter) {
        return new Function7<Integer, Boolean, String, String, Long, Boolean, String, Observable<Boolean>>() {
            @Override
            public Observable<Boolean> apply(Integer integer, Boolean aBoolean, String s, String s2, Long aLong, Boolean aBoolean2, String s3) {
                return Observable.just(!Boolean.valueOf(parameter));
            }
        };
    }

    private <T> Function8<Integer, Boolean, String, String, Long, Boolean, String, Boolean, Observable<Class<T>>> eight(final Class<T> item) {
        return new Function8<Integer, Boolean, String, String, Long, Boolean, String, Boolean, Observable<Class<T>>>() {
            @Override
            public Observable<Class<T>> apply(Integer integer, Boolean aBoolean, String s, String s2, Long aLong, Boolean aBoolean2, String s3, Boolean aBoolean3) {
                return Observable.just(item);
            }
        };
    }

    private <T> Function9<Integer, Boolean, String, String, Long, Boolean, String, Boolean, Class<T>, Observable<Object>> nine() {
        return new Function9<Integer, Boolean, String, String, Long, Boolean, String, Boolean, Class<T>, Observable<Object>>() {
            @Override
            public Observable<Object> apply(Integer integer, Boolean aBoolean, String s, String s2, Long aLong, Boolean aBoolean2, String s3, Boolean aBoolean3, Class<T> clazz) {
                return Observable.<Object>just(integer, aBoolean, s, s2, aLong, aBoolean2, s3, aBoolean3, clazz);
            }
        };
    }

    private ObservableTransformer<Integer, String> intIncrementToString() {
        return new ObservableTransformer<Integer, String>() {
            @Override
            public ObservableSource<String> apply(Observable<Integer> upstream) {
                return upstream.map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) {
                        return Integer.toString(integer + 1);
                    }
                });
            }
        };
    }

    private ObservableTransformer<String, Integer> stringToInt() {
        return new ObservableTransformer<String, Integer>() {
            @Override
            public ObservableSource<Integer> apply(Observable<String> upstream) {
                return upstream.map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s);
                    }
                });
            }
        };
    }

    // endregion

}
