/*
 *
 *  * Copyright (c) pakoito 2016
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *    http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.pacoworks.rxcomprehensions;

import org.junit.Assert;
import org.junit.Test;

import rx.Observable;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Func5;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;
import rx.functions.Func9;
import rx.observers.TestSubscriber;

public class RxComprehensionsTest {
    @Test
    public void oneFM() {
        Assert.assertEquals(RxComprehensions.forFM(zero(1), one(true)).toBlocking().first(), true);
    }

    @Test
    public void twoFM() {
        Assert.assertEquals(RxComprehensions.forFM(zero(2), one(true), two("result")).toBlocking().first(), "result");
    }

    @Test
    public void threeFM() {
        Assert.assertEquals(
                RxComprehensions.forFM(zero(3), one(true), two("result"), three("other")).toBlocking().first(),
                "other");
    }

    @Test
    public void fourFM() {
        Assert.assertEquals(RxComprehensions
                .forFM(zero(4), one(true), two("result"), three("other"), four("other".length())).toBlocking().first(),
                new Long("other".length()));
    }

    @Test
    public void fiveFM() {
        Assert.assertEquals(RxComprehensions.forFM(zero(1), one(true), two("result"), three("other"),
                four("other".length()), five("other".length() < 5)).toBlocking().first(), false);
    }

    @Test
    public void sixFM() {
        Assert.assertEquals(RxComprehensions.forFM(zero(1), one(true), two("result"), three("other"),
                four("other".length()), five("other".length() < 5), six(Boolean.toString(false))).toBlocking().first(),
                "false");
    }

    @Test
    public void sevenFM() {
        Assert.assertEquals(
                RxComprehensions
                        .forFM(zero(1), one(true), two("result"), three("other"), four("other".length()),
                                five("other".length() < 5), six(Boolean.toString(false)), seven("true"))
                        .toBlocking().first(),
                false);
    }

    @Test
    public void eightFM() {
        Assert.assertEquals(RxComprehensions
                .forFM(zero(1), one(true), two("result"), three("other"), four("other".length()),
                        five("other".length() < 5), six(Boolean.toString(false)), seven("true"), eight(Long.class))
                .toBlocking().first(), Long.class);
    }

    @Test
    public void nineFM() {
        final TestSubscriber<Object> observer = TestSubscriber.create();
        RxComprehensions.forFM(zero(1), one(true), two("result"), three("other"), four("other".length()),
                five("other".length() < 5), six(Boolean.toString(false)), seven("true"), eight(Long.class),
                this.<Long> nine()).subscribe(observer);
        observer.awaitTerminalEvent();
        observer.assertCompleted();
        observer.assertNoErrors();
        observer.assertValues(1, true, "result", "other", (long)"other".length(), "other".length() < 5,
                Boolean.toString(false), false, Long.class);
    }

    @Test
    public void oneCM() {
        Assert.assertEquals(RxComprehensions.forCM(zero(1), one(true)).toBlocking().first(), true);
    }

    @Test
    public void twoCM() {
        Assert.assertEquals(RxComprehensions.forCM(zero(2), one(true), two("result")).toBlocking().first(), "result");
    }

    @Test
    public void threeCM() {
        Assert.assertEquals(
                RxComprehensions.forCM(zero(3), one(true), two("result"), three("other")).toBlocking().first(),
                "other");
    }

    @Test
    public void fourCM() {
        Assert.assertEquals(RxComprehensions
                .forCM(zero(4), one(true), two("result"), three("other"), four("other".length())).toBlocking().first(),
                new Long("other".length()));
    }

    @Test
    public void fiveCM() {
        Assert.assertEquals(RxComprehensions.forCM(zero(1), one(true), two("result"), three("other"),
                four("other".length()), five("other".length() < 5)).toBlocking().first(), false);
    }

    @Test
    public void sixCM() {
        Assert.assertEquals(RxComprehensions.forCM(zero(1), one(true), two("result"), three("other"),
                four("other".length()), five("other".length() < 5), six(Boolean.toString(false))).toBlocking().first(),
                "false");
    }

    @Test
    public void sevenCM() {
        Assert.assertEquals(
                RxComprehensions
                        .forCM(zero(1), one(true), two("result"), three("other"), four("other".length()),
                                five("other".length() < 5), six(Boolean.toString(false)), seven("true"))
                        .toBlocking().first(),
                false);
    }

    @Test
    public void eightCM() {
        Assert.assertEquals(RxComprehensions
                .forCM(zero(1), one(true), two("result"), three("other"), four("other".length()),
                        five("other".length() < 5), six(Boolean.toString(false)), seven("true"), eight(Long.class))
                .toBlocking().first(), Long.class);
    }

    @Test
    public void nineCM() {
        final TestSubscriber<Object> observer = TestSubscriber.create();
        RxComprehensions.forCM(zero(1), one(true), two("result"), three("other"), four("other".length()),
                five("other".length() < 5), six(Boolean.toString(false)), seven("true"), eight(Long.class),
                this.<Long> nine()).subscribe(observer);
        observer.awaitTerminalEvent();
        observer.assertCompleted();
        observer.assertNoErrors();
        observer.assertValues(1, true, "result", "other", (long)"other".length(), "other".length() < 5,
                Boolean.toString(false), false, Long.class);
    }

    @Test
    public void oneSM() {
        Assert.assertEquals(RxComprehensions.forSM(zero(1), one(true)).toBlocking().first(), true);
    }

    @Test
    public void twoSM() {
        Assert.assertEquals(RxComprehensions.forSM(zero(2), one(true), two("result")).toBlocking().first(), "result");
    }

    @Test
    public void threeSM() {
        Assert.assertEquals(
                RxComprehensions.forSM(zero(3), one(true), two("result"), three("other")).toBlocking().first(),
                "other");
    }

    @Test
    public void fourSM() {
        Assert.assertEquals(RxComprehensions
                .forSM(zero(4), one(true), two("result"), three("other"), four("other".length())).toBlocking().first(),
                new Long("other".length()));
    }

    @Test
    public void fiveSM() {
        Assert.assertEquals(RxComprehensions.forSM(zero(1), one(true), two("result"), three("other"),
                four("other".length()), five("other".length() < 5)).toBlocking().first(), false);
    }

    @Test
    public void sixSM() {
        Assert.assertEquals(RxComprehensions.forSM(zero(1), one(true), two("result"), three("other"),
                four("other".length()), five("other".length() < 5), six(Boolean.toString(false))).toBlocking().first(),
                "false");
    }

    @Test
    public void sevenSM() {
        Assert.assertEquals(
                RxComprehensions
                        .forSM(zero(1), one(true), two("result"), three("other"), four("other".length()),
                                five("other".length() < 5), six(Boolean.toString(false)), seven("true"))
                        .toBlocking().first(),
                false);
    }

    @Test
    public void eightSM() {
        Assert.assertEquals(RxComprehensions
                .forSM(zero(1), one(true), two("result"), three("other"), four("other".length()),
                        five("other".length() < 5), six(Boolean.toString(false)), seven("true"), eight(Long.class))
                .toBlocking().first(), Long.class);
    }

    @Test
    public void nineSM() {
        final TestSubscriber<Object> observer = TestSubscriber.create();
        RxComprehensions.forSM(zero(1), one(true), two("result"), three("other"), four("other".length()),
                five("other".length() < 5), six(Boolean.toString(false)), seven("true"), eight(Long.class),
                this.<Long> nine()).subscribe(observer);
        observer.awaitTerminalEvent();
        observer.assertCompleted();
        observer.assertNoErrors();
        observer.assertValues(1, true, "result", "other", (long)"other".length(), "other".length() < 5,
                Boolean.toString(false), false, Long.class);
    }

    private Func0<Observable<Integer>> zero(final int i) {
        return new Func0<Observable<Integer>>() {
            @Override
            public Observable<Integer> call() {
                return Observable.just(i);
            }
        };
    }

    private Func1<Integer, Observable<Boolean>> one(final boolean value) {
        return new Func1<Integer, Observable<Boolean>>() {
            @Override
            public Observable<Boolean> call(Integer integer) {
                return Observable.just(value);
            }
        };
    }

    private Func2<Integer, Boolean, Observable<String>> two(final String value) {
        return new Func2<Integer, Boolean, Observable<String>>() {
            @Override
            public Observable<String> call(Integer integer, Boolean aBoolean) {
                return Observable.just(value);
            }
        };
    }

    private Func3<Integer, Boolean, String, Observable<String>> three(final String other) {
        return new Func3<Integer, Boolean, String, Observable<String>>() {
            @Override
            public Observable<String> call(Integer integer, Boolean aBoolean, String s) {
                return Observable.just(other);
            }
        };
    }

    private Func4<Integer, Boolean, String, String, Observable<Long>> four(final long length) {
        return new Func4<Integer, Boolean, String, String, Observable<Long>>() {
            @Override
            public Observable<Long> call(Integer integer, Boolean aBoolean, String s, String s2) {
                return Observable.just(length);
            }
        };
    }

    private Func5<Integer, Boolean, String, String, Long, Observable<Boolean>> five(final boolean b) {
        return new Func5<Integer, Boolean, String, String, Long, Observable<Boolean>>() {
            @Override
            public Observable<Boolean> call(Integer integer, Boolean aBoolean, String s, String s2, Long aLong) {
                return Observable.just(b);
            }
        };
    }

    private Func6<Integer, Boolean, String, String, Long, Boolean, Observable<String>> six(final String string) {
        return new Func6<Integer, Boolean, String, String, Long, Boolean, Observable<String>>() {
            @Override
            public Observable<String> call(Integer integer, Boolean aBoolean, String s, String s2, Long aLong,
                    Boolean aBoolean2) {
                return Observable.just(string);
            }
        };
    }

    private Func7<Integer, Boolean, String, String, Long, Boolean, String, Observable<Boolean>> seven(
            final String parameter) {
        return new Func7<Integer, Boolean, String, String, Long, Boolean, String, Observable<Boolean>>() {
            @Override
            public Observable<Boolean> call(Integer integer, Boolean aBoolean, String s, String s2, Long aLong,
                    Boolean aBoolean2, String s3) {
                return Observable.just(!Boolean.valueOf(parameter));
            }
        };
    }

    private <T> Func8<Integer, Boolean, String, String, Long, Boolean, String, Boolean, Observable<Class<T>>> eight(
            final Class<T> item) {
        return new Func8<Integer, Boolean, String, String, Long, Boolean, String, Boolean, Observable<Class<T>>>() {
            @Override
            public Observable<Class<T>> call(Integer integer, Boolean aBoolean, String s, String s2, Long aLong,
                    Boolean aBoolean2, String s3, Boolean aBoolean3) {
                return Observable.just(item);
            }
        };
    }

    private <T> Func9<Integer, Boolean, String, String, Long, Boolean, String, Boolean, Class<T>, Observable<Object>> nine() {
        return new Func9<Integer, Boolean, String, String, Long, Boolean, String, Boolean, Class<T>, Observable<Object>>() {
            @Override
            public Observable<Object> call(Integer integer, Boolean aBoolean, String s, String s2, Long aLong,
                    Boolean aBoolean2, String s3, Boolean aBoolean3, Class<T> o) {
                return Observable.<Object> just(integer, aBoolean, s, s2, aLong, aBoolean2, s3, aBoolean3, o);
            }
        };
    }
}
