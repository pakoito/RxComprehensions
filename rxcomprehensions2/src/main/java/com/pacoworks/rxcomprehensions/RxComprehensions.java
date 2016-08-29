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

import java.util.concurrent.Callable;

import io.reactivex.Observable;
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
 * Helper class to reduce boilerplate in Observable chains by abstracting flatMap.
 *
 * @author pakoito
 */
public final class RxComprehensions {
    private RxComprehensions() {
        // No instances
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by
     * .flatMap.
     *
     * @return composed Observable
     */
    public static <A, R> Observable<R> forFM(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<R>> one) throws Exception {
        return zero.call()
                .flatMap(new Function<A, Observable<R>>() {
                    @Override
                    public Observable<R> apply(final A a) throws Exception {
                        return one.apply(a);
                    }
                });
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by
     * .flatMap.
     *
     * @return composed Observable
     */
    public static <A, B, R> Observable<R> forFM(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<R>> two) throws Exception {
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
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by
     * .flatMap.
     *
     * @return composed Observable
     */
    public static <A, B, C, R> Observable<R> forFM(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<R>> three) throws Exception {
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
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by
     * .flatMap.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, R> Observable<R> forFM(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<R>> four) throws Exception {
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
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by
     * .flatMap.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, R> Observable<R> forFM(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<R>> five) throws Exception {
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
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by
     * .flatMap.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, R> Observable<R> forFM(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<F>> five,
            final Function6<A, B, C, D, E, F, Observable<R>> six) throws Exception {
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
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by
     * .flatMap.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, R> Observable<R> forFM(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<F>> five,
            final Function6<A, B, C, D, E, F, Observable<G>> six,
            final Function7<A, B, C, D, E, F, G, Observable<R>> seven) throws Exception {
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
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by
     * .flatMap.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, H, R> Observable<R> forFM(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<F>> five,
            final Function6<A, B, C, D, E, F, Observable<G>> six,
            final Function7<A, B, C, D, E, F, G, Observable<H>> seven,
            final Function8<A, B, C, D, E, F, G, H, Observable<R>> eight) throws Exception {
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
    }

    /**
     * Composes an {@link io.reactivex.Observable} from multiple creation functions chained by
     * .flatMap.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, H, I, R> Observable<R> forFM(
            final Callable<Observable<A>> zero,
            final Function<A, Observable<B>> one,
            final BiFunction<A, B, Observable<C>> two,
            final Function3<A, B, C, Observable<D>> three,
            final Function4<A, B, C, D, Observable<E>> four,
            final Function5<A, B, C, D, E, Observable<F>> five,
            final Function6<A, B, C, D, E, F, Observable<G>> six,
            final Function7<A, B, C, D, E, F, G, Observable<H>> seven,
            final Function8<A, B, C, D, E, F, G, H, Observable<I>> eight,
            final Function9<A, B, C, D, E, F, G, H, I, Observable<R>> nine) throws Exception {
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
    }
}
