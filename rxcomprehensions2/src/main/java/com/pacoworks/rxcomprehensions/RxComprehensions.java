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

import java.util.concurrent.Callable;

import io.reactivex.Observable;
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

/**
 * Helper class to reduce boilerplate introduced by nested {@link Observable#flatMap(Function)}, {@link Observable#concatMap(Function)}, and {@link Observable#switchMap(Function)} calls.
 *
 * @author pakoito
 */
public final class RxComprehensions {
    private RxComprehensions() {
        // No instances
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#flatMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, R> Observable<R> doFlatMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<R>> one) {
        try {
            return zero.call()
                    .flatMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a);
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#flatMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, R> Observable<R> doFlatMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<R>> two) {
        try {
            return zero.call()
                    .flatMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .flatMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b);
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#flatMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, R> Observable<R> doFlatMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<R>> three) {
        try {
            return zero.call()
                    .flatMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .flatMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .flatMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c);
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#flatMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, R> Observable<R> doFlatMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<R>> four) {
        try {
            return zero.call()
                    .flatMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .flatMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .flatMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c)
                                                                    .flatMap(new Function<D, Observable<R>>() {
                                                                        @Override
                                                                        public Observable<R> apply(final D d) throws Exception {
                                                                            return four.apply(a, b, c, d);
                                                                        }
                                                                    });
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#flatMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, R> Observable<R> doFlatMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<R>> five) {
        try {
            return zero.call()
                    .flatMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .flatMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .flatMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c)
                                                                    .flatMap(new Function<D, Observable<R>>() {
                                                                        @Override
                                                                        public Observable<R> apply(final D d) throws Exception {
                                                                            return four.apply(a, b, c, d)
                                                                                    .flatMap(new Function<E, Observable<R>>() {
                                                                                        @Override
                                                                                        public Observable<R> apply(final E e) throws Exception {
                                                                                            return five.apply(a, b, c, d, e);
                                                                                        }
                                                                                    });
                                                                        }
                                                                    });
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#flatMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, R> Observable<R> doFlatMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<F>> five,
            final Function6<A, B, C, D, E, F, Observable<R>> six) {
        try {
            return zero.call()
                    .flatMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .flatMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .flatMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c)
                                                                    .flatMap(new Function<D, Observable<R>>() {
                                                                        @Override
                                                                        public Observable<R> apply(final D d) throws Exception {
                                                                            return four.apply(a, b, c, d)
                                                                                    .flatMap(new Function<E, Observable<R>>() {
                                                                                        @Override
                                                                                        public Observable<R> apply(final E e) throws Exception {
                                                                                            return five.apply(a, b, c, d, e)
                                                                                                    .flatMap(new Function<F, Observable<R>>() {
                                                                                                        @Override
                                                                                                        public Observable<R> apply(final F f) throws Exception {
                                                                                                            return six.apply(a, b, c, d, e, f);
                                                                                                        }
                                                                                                    });
                                                                                        }
                                                                                    });
                                                                        }
                                                                    });
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#flatMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, R> Observable<R> doFlatMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<F>> five,
            final Function6<A, B, C, D, E, F, Observable<G>> six,
            final Function7<A, B, C, D, E, F, G, Observable<R>> seven) {
        try {
            return zero.call()
                    .flatMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .flatMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .flatMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c)
                                                                    .flatMap(new Function<D, Observable<R>>() {
                                                                        @Override
                                                                        public Observable<R> apply(final D d) throws Exception {
                                                                            return four.apply(a, b, c, d)
                                                                                    .flatMap(new Function<E, Observable<R>>() {
                                                                                        @Override
                                                                                        public Observable<R> apply(final E e) throws Exception {
                                                                                            return five.apply(a, b, c, d, e)
                                                                                                    .flatMap(new Function<F, Observable<R>>() {
                                                                                                        @Override
                                                                                                        public Observable<R> apply(final F f) throws Exception {
                                                                                                            return six.apply(a, b, c, d, e, f)
                                                                                                                    .flatMap(new Function<G, Observable<R>>() {
                                                                                                                        @Override
                                                                                                                        public Observable<R> apply(final G g) throws Exception {
                                                                                                                            return seven.apply(a, b, c, d, e, f, g);
                                                                                                                        }
                                                                                                                    });
                                                                                                        }
                                                                                                    });
                                                                                        }
                                                                                    });
                                                                        }
                                                                    });
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#flatMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, H, R> Observable<R> doFlatMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<F>> five,
            final Function6<A, B, C, D, E, F, Observable<G>> six,
            final Function7<A, B, C, D, E, F, G, Observable<H>> seven,
            final Function8<A, B, C, D, E, F, G, H, Observable<R>> eight) {
        try {
            return zero.call()
                    .flatMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .flatMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .flatMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c)
                                                                    .flatMap(new Function<D, Observable<R>>() {
                                                                        @Override
                                                                        public Observable<R> apply(final D d) throws Exception {
                                                                            return four.apply(a, b, c, d)
                                                                                    .flatMap(new Function<E, Observable<R>>() {
                                                                                        @Override
                                                                                        public Observable<R> apply(final E e) throws Exception {
                                                                                            return five.apply(a, b, c, d, e)
                                                                                                    .flatMap(new Function<F, Observable<R>>() {
                                                                                                        @Override
                                                                                                        public Observable<R> apply(final F f) throws Exception {
                                                                                                            return six.apply(a, b, c, d, e, f)
                                                                                                                    .flatMap(new Function<G, Observable<R>>() {
                                                                                                                        @Override
                                                                                                                        public Observable<R> apply(final G g) throws Exception {
                                                                                                                            return seven.apply(a, b, c, d, e, f, g)
                                                                                                                                    .flatMap(new Function<H, Observable<R>>() {
                                                                                                                                        @Override
                                                                                                                                        public Observable<R> apply(final H h) throws Exception {
                                                                                                                                            return eight.apply(a, b, c, d, e, f, g, h);
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                        }
                                                                                                                    });
                                                                                                        }
                                                                                                    });
                                                                                        }
                                                                                    });
                                                                        }
                                                                    });
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#flatMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, H, I, R> Observable<R> doFlatMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<F>> five,
            final Function6<A, B, C, D, E, F, Observable<G>> six,
            final Function7<A, B, C, D, E, F, G, Observable<H>> seven,
            final Function8<A, B, C, D, E, F, G, H, Observable<I>> eight,
            final Function9<A, B, C, D, E, F, G, H, I, Observable<R>> nine) {
        try {
            return zero.call()
                    .flatMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .flatMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .flatMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c)
                                                                    .flatMap(new Function<D, Observable<R>>() {
                                                                        @Override
                                                                        public Observable<R> apply(final D d) throws Exception {
                                                                            return four.apply(a, b, c, d)
                                                                                    .flatMap(new Function<E, Observable<R>>() {
                                                                                        @Override
                                                                                        public Observable<R> apply(final E e) throws Exception {
                                                                                            return five.apply(a, b, c, d, e)
                                                                                                    .flatMap(new Function<F, Observable<R>>() {
                                                                                                        @Override
                                                                                                        public Observable<R> apply(final F f) throws Exception {
                                                                                                            return six.apply(a, b, c, d, e, f)
                                                                                                                    .flatMap(new Function<G, Observable<R>>() {
                                                                                                                        @Override
                                                                                                                        public Observable<R> apply(final G g) throws Exception {
                                                                                                                            return seven.apply(a, b, c, d, e, f, g)
                                                                                                                                    .flatMap(new Function<H, Observable<R>>() {
                                                                                                                                        @Override
                                                                                                                                        public Observable<R> apply(final H h) throws Exception {
                                                                                                                                            return eight.apply(a, b, c, d, e, f, g, h)
                                                                                                                                                    .flatMap(new Function<I, Observable<R>>() {
                                                                                                                                                        @Override
                                                                                                                                                        public Observable<R> apply(final I i) throws Exception {
                                                                                                                                                            return nine.apply(a, b, c, d, e, f, g, h, i);
                                                                                                                                                        }
                                                                                                                                                    });
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                        }
                                                                                                                    });
                                                                                                        }
                                                                                                    });
                                                                                        }
                                                                                    });
                                                                        }
                                                                    });
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#concatMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, R> Observable<R> doConcatMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<R>> one) {
        try {
            return zero.call()
                    .concatMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a);
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#concatMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, R> Observable<R> doConcatMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<R>> two) {
        try {
            return zero.call()
                    .concatMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .concatMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b);
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#concatMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, R> Observable<R> doConcatMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<R>> three) {
        try {
            return zero.call()
                    .concatMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .concatMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .concatMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c);
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#concatMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, R> Observable<R> doConcatMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<R>> four) {
        try {
            return zero.call()
                    .concatMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .concatMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .concatMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c)
                                                                    .concatMap(new Function<D, Observable<R>>() {
                                                                        @Override
                                                                        public Observable<R> apply(final D d) throws Exception {
                                                                            return four.apply(a, b, c, d);
                                                                        }
                                                                    });
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#concatMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, R> Observable<R> doConcatMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<R>> five) {
        try {
            return zero.call()
                    .concatMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .concatMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .concatMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c)
                                                                    .concatMap(new Function<D, Observable<R>>() {
                                                                        @Override
                                                                        public Observable<R> apply(final D d) throws Exception {
                                                                            return four.apply(a, b, c, d)
                                                                                    .concatMap(new Function<E, Observable<R>>() {
                                                                                        @Override
                                                                                        public Observable<R> apply(final E e) throws Exception {
                                                                                            return five.apply(a, b, c, d, e);
                                                                                        }
                                                                                    });
                                                                        }
                                                                    });
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#concatMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, R> Observable<R> doConcatMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<F>> five,
            final Function6<A, B, C, D, E, F, Observable<R>> six) {
        try {
            return zero.call()
                    .concatMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .concatMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .concatMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c)
                                                                    .concatMap(new Function<D, Observable<R>>() {
                                                                        @Override
                                                                        public Observable<R> apply(final D d) throws Exception {
                                                                            return four.apply(a, b, c, d)
                                                                                    .concatMap(new Function<E, Observable<R>>() {
                                                                                        @Override
                                                                                        public Observable<R> apply(final E e) throws Exception {
                                                                                            return five.apply(a, b, c, d, e)
                                                                                                    .concatMap(new Function<F, Observable<R>>() {
                                                                                                        @Override
                                                                                                        public Observable<R> apply(final F f) throws Exception {
                                                                                                            return six.apply(a, b, c, d, e, f);
                                                                                                        }
                                                                                                    });
                                                                                        }
                                                                                    });
                                                                        }
                                                                    });
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#concatMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, R> Observable<R> doConcatMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<F>> five,
            final Function6<A, B, C, D, E, F, Observable<G>> six,
            final Function7<A, B, C, D, E, F, G, Observable<R>> seven) {
        try {
            return zero.call()
                    .concatMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .concatMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .concatMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c)
                                                                    .concatMap(new Function<D, Observable<R>>() {
                                                                        @Override
                                                                        public Observable<R> apply(final D d) throws Exception {
                                                                            return four.apply(a, b, c, d)
                                                                                    .concatMap(new Function<E, Observable<R>>() {
                                                                                        @Override
                                                                                        public Observable<R> apply(final E e) throws Exception {
                                                                                            return five.apply(a, b, c, d, e)
                                                                                                    .concatMap(new Function<F, Observable<R>>() {
                                                                                                        @Override
                                                                                                        public Observable<R> apply(final F f) throws Exception {
                                                                                                            return six.apply(a, b, c, d, e, f)
                                                                                                                    .concatMap(new Function<G, Observable<R>>() {
                                                                                                                        @Override
                                                                                                                        public Observable<R> apply(final G g) throws Exception {
                                                                                                                            return seven.apply(a, b, c, d, e, f, g);
                                                                                                                        }
                                                                                                                    });
                                                                                                        }
                                                                                                    });
                                                                                        }
                                                                                    });
                                                                        }
                                                                    });
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#concatMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, H, R> Observable<R> doConcatMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<F>> five,
            final Function6<A, B, C, D, E, F, Observable<G>> six,
            final Function7<A, B, C, D, E, F, G, Observable<H>> seven,
            final Function8<A, B, C, D, E, F, G, H, Observable<R>> eight) {
        try {
            return zero.call()
                    .concatMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .concatMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .concatMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c)
                                                                    .concatMap(new Function<D, Observable<R>>() {
                                                                        @Override
                                                                        public Observable<R> apply(final D d) throws Exception {
                                                                            return four.apply(a, b, c, d)
                                                                                    .concatMap(new Function<E, Observable<R>>() {
                                                                                        @Override
                                                                                        public Observable<R> apply(final E e) throws Exception {
                                                                                            return five.apply(a, b, c, d, e)
                                                                                                    .concatMap(new Function<F, Observable<R>>() {
                                                                                                        @Override
                                                                                                        public Observable<R> apply(final F f) throws Exception {
                                                                                                            return six.apply(a, b, c, d, e, f)
                                                                                                                    .concatMap(new Function<G, Observable<R>>() {
                                                                                                                        @Override
                                                                                                                        public Observable<R> apply(final G g) throws Exception {
                                                                                                                            return seven.apply(a, b, c, d, e, f, g)
                                                                                                                                    .concatMap(new Function<H, Observable<R>>() {
                                                                                                                                        @Override
                                                                                                                                        public Observable<R> apply(final H h) throws Exception {
                                                                                                                                            return eight.apply(a, b, c, d, e, f, g, h);
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                        }
                                                                                                                    });
                                                                                                        }
                                                                                                    });
                                                                                        }
                                                                                    });
                                                                        }
                                                                    });
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#concatMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, H, I, R> Observable<R> doConcatMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<F>> five,
            final Function6<A, B, C, D, E, F, Observable<G>> six,
            final Function7<A, B, C, D, E, F, G, Observable<H>> seven,
            final Function8<A, B, C, D, E, F, G, H, Observable<I>> eight,
            final Function9<A, B, C, D, E, F, G, H, I, Observable<R>> nine) {
        try {
            return zero.call()
                    .concatMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .concatMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .concatMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c)
                                                                    .concatMap(new Function<D, Observable<R>>() {
                                                                        @Override
                                                                        public Observable<R> apply(final D d) throws Exception {
                                                                            return four.apply(a, b, c, d)
                                                                                    .concatMap(new Function<E, Observable<R>>() {
                                                                                        @Override
                                                                                        public Observable<R> apply(final E e) throws Exception {
                                                                                            return five.apply(a, b, c, d, e)
                                                                                                    .concatMap(new Function<F, Observable<R>>() {
                                                                                                        @Override
                                                                                                        public Observable<R> apply(final F f) throws Exception {
                                                                                                            return six.apply(a, b, c, d, e, f)
                                                                                                                    .concatMap(new Function<G, Observable<R>>() {
                                                                                                                        @Override
                                                                                                                        public Observable<R> apply(final G g) throws Exception {
                                                                                                                            return seven.apply(a, b, c, d, e, f, g)
                                                                                                                                    .concatMap(new Function<H, Observable<R>>() {
                                                                                                                                        @Override
                                                                                                                                        public Observable<R> apply(final H h) throws Exception {
                                                                                                                                            return eight.apply(a, b, c, d, e, f, g, h)
                                                                                                                                                    .concatMap(new Function<I, Observable<R>>() {
                                                                                                                                                        @Override
                                                                                                                                                        public Observable<R> apply(final I i) throws Exception {
                                                                                                                                                            return nine.apply(a, b, c, d, e, f, g, h, i);
                                                                                                                                                        }
                                                                                                                                                    });
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                        }
                                                                                                                    });
                                                                                                        }
                                                                                                    });
                                                                                        }
                                                                                    });
                                                                        }
                                                                    });
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#switchMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, R> Observable<R> doSwitchMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<R>> one) {
        try {
            return zero.call()
                    .switchMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a);
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#switchMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, R> Observable<R> doSwitchMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<R>> two) {
        try {
            return zero.call()
                    .switchMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .switchMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b);
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#switchMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, R> Observable<R> doSwitchMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<R>> three) {
        try {
            return zero.call()
                    .switchMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .switchMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .switchMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c);
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#switchMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, R> Observable<R> doSwitchMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<R>> four) {
        try {
            return zero.call()
                    .switchMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .switchMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .switchMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c)
                                                                    .switchMap(new Function<D, Observable<R>>() {
                                                                        @Override
                                                                        public Observable<R> apply(final D d) throws Exception {
                                                                            return four.apply(a, b, c, d);
                                                                        }
                                                                    });
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#switchMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, R> Observable<R> doSwitchMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<R>> five) {
        try {
            return zero.call()
                    .switchMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .switchMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .switchMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c)
                                                                    .switchMap(new Function<D, Observable<R>>() {
                                                                        @Override
                                                                        public Observable<R> apply(final D d) throws Exception {
                                                                            return four.apply(a, b, c, d)
                                                                                    .switchMap(new Function<E, Observable<R>>() {
                                                                                        @Override
                                                                                        public Observable<R> apply(final E e) throws Exception {
                                                                                            return five.apply(a, b, c, d, e);
                                                                                        }
                                                                                    });
                                                                        }
                                                                    });
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#switchMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, R> Observable<R> doSwitchMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<F>> five,
            final Function6<A, B, C, D, E, F, Observable<R>> six) {
        try {
            return zero.call()
                    .switchMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .switchMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .switchMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c)
                                                                    .switchMap(new Function<D, Observable<R>>() {
                                                                        @Override
                                                                        public Observable<R> apply(final D d) throws Exception {
                                                                            return four.apply(a, b, c, d)
                                                                                    .switchMap(new Function<E, Observable<R>>() {
                                                                                        @Override
                                                                                        public Observable<R> apply(final E e) throws Exception {
                                                                                            return five.apply(a, b, c, d, e)
                                                                                                    .switchMap(new Function<F, Observable<R>>() {
                                                                                                        @Override
                                                                                                        public Observable<R> apply(final F f) throws Exception {
                                                                                                            return six.apply(a, b, c, d, e, f);
                                                                                                        }
                                                                                                    });
                                                                                        }
                                                                                    });
                                                                        }
                                                                    });
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#switchMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, R> Observable<R> doSwitchMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<F>> five,
            final Function6<A, B, C, D, E, F, Observable<G>> six,
            final Function7<A, B, C, D, E, F, G, Observable<R>> seven) {
        try {
            return zero.call()
                    .switchMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .switchMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .switchMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c)
                                                                    .switchMap(new Function<D, Observable<R>>() {
                                                                        @Override
                                                                        public Observable<R> apply(final D d) throws Exception {
                                                                            return four.apply(a, b, c, d)
                                                                                    .switchMap(new Function<E, Observable<R>>() {
                                                                                        @Override
                                                                                        public Observable<R> apply(final E e) throws Exception {
                                                                                            return five.apply(a, b, c, d, e)
                                                                                                    .switchMap(new Function<F, Observable<R>>() {
                                                                                                        @Override
                                                                                                        public Observable<R> apply(final F f) throws Exception {
                                                                                                            return six.apply(a, b, c, d, e, f)
                                                                                                                    .switchMap(new Function<G, Observable<R>>() {
                                                                                                                        @Override
                                                                                                                        public Observable<R> apply(final G g) throws Exception {
                                                                                                                            return seven.apply(a, b, c, d, e, f, g);
                                                                                                                        }
                                                                                                                    });
                                                                                                        }
                                                                                                    });
                                                                                        }
                                                                                    });
                                                                        }
                                                                    });
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#switchMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, H, R> Observable<R> doSwitchMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<F>> five,
            final Function6<A, B, C, D, E, F, Observable<G>> six,
            final Function7<A, B, C, D, E, F, G, Observable<H>> seven,
            final Function8<A, B, C, D, E, F, G, H, Observable<R>> eight) {
        try {
            return zero.call()
                    .switchMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .switchMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .switchMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c)
                                                                    .switchMap(new Function<D, Observable<R>>() {
                                                                        @Override
                                                                        public Observable<R> apply(final D d) throws Exception {
                                                                            return four.apply(a, b, c, d)
                                                                                    .switchMap(new Function<E, Observable<R>>() {
                                                                                        @Override
                                                                                        public Observable<R> apply(final E e) throws Exception {
                                                                                            return five.apply(a, b, c, d, e)
                                                                                                    .switchMap(new Function<F, Observable<R>>() {
                                                                                                        @Override
                                                                                                        public Observable<R> apply(final F f) throws Exception {
                                                                                                            return six.apply(a, b, c, d, e, f)
                                                                                                                    .switchMap(new Function<G, Observable<R>>() {
                                                                                                                        @Override
                                                                                                                        public Observable<R> apply(final G g) throws Exception {
                                                                                                                            return seven.apply(a, b, c, d, e, f, g)
                                                                                                                                    .switchMap(new Function<H, Observable<R>>() {
                                                                                                                                        @Override
                                                                                                                                        public Observable<R> apply(final H h) throws Exception {
                                                                                                                                            return eight.apply(a, b, c, d, e, f, g, h);
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                        }
                                                                                                                    });
                                                                                                        }
                                                                                                    });
                                                                                        }
                                                                                    });
                                                                        }
                                                                    });
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by {@link Observable#switchMap(Function)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, H, I, R> Observable<R> doSwitchMap(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<F>> five,
            final Function6<A, B, C, D, E, F, Observable<G>> six,
            final Function7<A, B, C, D, E, F, G, Observable<H>> seven,
            final Function8<A, B, C, D, E, F, G, H, Observable<I>> eight,
            final Function9<A, B, C, D, E, F, G, H, I, Observable<R>> nine) {
        try {
            return zero.call()
                    .switchMap(new Function<A, Observable<R>>() {
                        @Override
                        public Observable<R> apply(final A a) throws Exception {
                            return one.apply(a)
                                    .switchMap(new Function<B, Observable<R>>() {
                                        @Override
                                        public Observable<R> apply(final B b) throws Exception {
                                            return two.apply(a, b)
                                                    .switchMap(new Function<C, Observable<R>>() {
                                                        @Override
                                                        public Observable<R> apply(final C c) throws Exception {
                                                            return three.apply(a, b, c)
                                                                    .switchMap(new Function<D, Observable<R>>() {
                                                                        @Override
                                                                        public Observable<R> apply(final D d) throws Exception {
                                                                            return four.apply(a, b, c, d)
                                                                                    .switchMap(new Function<E, Observable<R>>() {
                                                                                        @Override
                                                                                        public Observable<R> apply(final E e) throws Exception {
                                                                                            return five.apply(a, b, c, d, e)
                                                                                                    .switchMap(new Function<F, Observable<R>>() {
                                                                                                        @Override
                                                                                                        public Observable<R> apply(final F f) throws Exception {
                                                                                                            return six.apply(a, b, c, d, e, f)
                                                                                                                    .switchMap(new Function<G, Observable<R>>() {
                                                                                                                        @Override
                                                                                                                        public Observable<R> apply(final G g) throws Exception {
                                                                                                                            return seven.apply(a, b, c, d, e, f, g)
                                                                                                                                    .switchMap(new Function<H, Observable<R>>() {
                                                                                                                                        @Override
                                                                                                                                        public Observable<R> apply(final H h) throws Exception {
                                                                                                                                            return eight.apply(a, b, c, d, e, f, g, h)
                                                                                                                                                    .switchMap(new Function<I, Observable<R>>() {
                                                                                                                                                        @Override
                                                                                                                                                        public Observable<R> apply(final I i) throws Exception {
                                                                                                                                                            return nine.apply(a, b, c, d, e, f, g, h, i);
                                                                                                                                                        }
                                                                                                                                                    });
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                        }
                                                                                                                    });
                                                                                                        }
                                                                                                    });
                                                                                        }
                                                                                    });
                                                                        }
                                                                    });
                                                        }
                                                    });
                                        }
                                    });
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Composes an {@link Observable} from multiple {@link Function} chained by {@link Observable#compose(ObservableTransformer)}.
     *
     * @return composed Observable
     */
    public static <A, R> Observable<R> doCompose(
            final Callable<Observable<A>> zero,
            final ObservableTransformer<A, R> one) {
        try {
            return zero.call()
                    .compose(one);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link Observable} from multiple {@link Function} chained by {@link Observable#compose(ObservableTransformer)}.
     *
     * @return composed Observable
     */
    public static <A, B, R> Observable<R> doCompose(
            final Callable<Observable<A>> zero,
            final ObservableTransformer<A, B> one,
            final ObservableTransformer<B, R> two) {
        try {
            return zero.call()
                    .compose(one)
                    .compose(two);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link Observable} from multiple {@link Function} chained by {@link Observable#compose(ObservableTransformer)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, R> Observable<R> doCompose(
            final Callable<Observable<A>> zero,
            final ObservableTransformer<A, B> one,
            final ObservableTransformer<B, C> two,
            final ObservableTransformer<C, R> three) {
        try {
            return zero.call()
                    .compose(one)
                    .compose(two)
                    .compose(three);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link Observable} from multiple {@link Function} chained by {@link Observable#compose(ObservableTransformer)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, R> Observable<R> doCompose(
            final Callable<Observable<A>> zero,
            final ObservableTransformer<A, B> one,
            final ObservableTransformer<B, C> two,
            final ObservableTransformer<C, D> three,
            final ObservableTransformer<D, R> four) {
        try {
            return zero.call()
                    .compose(one)
                    .compose(two)
                    .compose(three)
                    .compose(four);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link Observable} from multiple {@link Function} chained by {@link Observable#compose(ObservableTransformer)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, R> Observable<R> doCompose(
            final Callable<Observable<A>> zero,
            final ObservableTransformer<A, B> one,
            final ObservableTransformer<B, C> two,
            final ObservableTransformer<C, D> three,
            final ObservableTransformer<D, E> four,
            final ObservableTransformer<E, R> five) {
        try {
            return zero.call()
                    .compose(one)
                    .compose(two)
                    .compose(three)
                    .compose(four)
                    .compose(five);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link Observable} from multiple {@link Function} chained by {@link Observable#compose(ObservableTransformer)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, R> Observable<R> doCompose(
            final Callable<Observable<A>> zero,
            final ObservableTransformer<A, B> one,
            final ObservableTransformer<B, C> two,
            final ObservableTransformer<C, D> three,
            final ObservableTransformer<D, E> four,
            final ObservableTransformer<E, F> five,
            final ObservableTransformer<F, R> six) {
        try {
            return zero.call()
                    .compose(one)
                    .compose(two)
                    .compose(three)
                    .compose(four)
                    .compose(five)
                    .compose(six);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link Observable} from multiple {@link Function} chained by {@link Observable#compose(ObservableTransformer)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, R> Observable<R> doCompose(
            final Callable<Observable<A>> zero,
            final ObservableTransformer<A, B> one,
            final ObservableTransformer<B, C> two,
            final ObservableTransformer<C, D> three,
            final ObservableTransformer<D, E> four,
            final ObservableTransformer<E, F> five,
            final ObservableTransformer<F, G> six,
            final ObservableTransformer<G, R> seven) {
        try {
            return zero.call()
                    .compose(one)
                    .compose(two)
                    .compose(three)
                    .compose(four)
                    .compose(five)
                    .compose(six)
                    .compose(seven);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link Observable} from multiple {@link Function} chained by {@link Observable#compose(ObservableTransformer)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, H, R> Observable<R> doCompose(
            final Callable<Observable<A>> zero,
            final ObservableTransformer<A, B> one,
            final ObservableTransformer<B, C> two,
            final ObservableTransformer<C, D> three,
            final ObservableTransformer<D, E> four,
            final ObservableTransformer<E, F> five,
            final ObservableTransformer<F, G> six,
            final ObservableTransformer<G, H> seven,
            final ObservableTransformer<H, R> eight) {
        try {
            return zero.call()
                    .compose(one)
                    .compose(two)
                    .compose(three)
                    .compose(four)
                    .compose(five)
                    .compose(six)
                    .compose(seven)
                    .compose(eight);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Composes an {@link Observable} from multiple {@link Function} chained by {@link Observable#compose(ObservableTransformer)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, H, I, R> Observable<R> doCompose(
            final Callable<Observable<A>> zero,
            final ObservableTransformer<A, B> one,
            final ObservableTransformer<B, C> two,
            final ObservableTransformer<C, D> three,
            final ObservableTransformer<D, E> four,
            final ObservableTransformer<E, F> five,
            final ObservableTransformer<F, G> six,
            final ObservableTransformer<G, H> seven,
            final ObservableTransformer<H, I> eight,
            final ObservableTransformer<I, R> nine) {
        try {
            return zero.call()
                    .compose(one)
                    .compose(two)
                    .compose(three)
                    .compose(four)
                    .compose(five)
                    .compose(six)
                    .compose(seven)
                    .compose(eight)
                    .compose(nine);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
