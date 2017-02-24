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

import rx.Observable;
import rx.Observable.Transformer;
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

/**
 * Helper class to reduce boilerplate introduced by nested {@link Observable#flatMap(Func1)}, {@link Observable#concatMap(Func1)}, and {@link Observable#switchMap(Func1)} calls.
 *
 * @author pakoito
 */
public final class RxComprehensions {
    private RxComprehensions() {
        // No instances
    }

    /**
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#flatMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, R> Observable<R> doFlatMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<R>> one) {
        return zero.call().flatMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a);
            }
        });
    }

    /**
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#flatMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, R> Observable<R> doFlatMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<R>> two) {
        return zero.call().flatMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).flatMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b);
                    }
                });
            }
        });
    }

    /**
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#flatMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, R> Observable<R> doFlatMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<R>> three) {
        return zero.call().flatMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).flatMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).flatMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c);
                            }
                        });
                    }
                });
            }
        });
    }

    /**
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#flatMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, R> Observable<R> doFlatMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<D>> three,
            final Func4<A, B, C, D, Observable<R>> four) {
        return zero.call().flatMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).flatMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).flatMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c).flatMap(new Func1<D, Observable<R>>() {
                                    @Override
                                    public Observable<R> call(final D d) {
                                        return four.call(a, b, c, d);
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
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#flatMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, R> Observable<R> doFlatMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<D>> three,
            final Func4<A, B, C, D, Observable<E>> four,
            final Func5<A, B, C, D, E, Observable<R>> five) {
        return zero.call().flatMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).flatMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).flatMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c).flatMap(new Func1<D, Observable<R>>() {
                                    @Override
                                    public Observable<R> call(final D d) {
                                        return four.call(a, b, c, d).flatMap(new Func1<E, Observable<R>>() {
                                            @Override
                                            public Observable<R> call(final E e) {
                                                return five.call(a, b, c, d, e);
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
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#flatMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, R> Observable<R> doFlatMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<D>> three,
            final Func4<A, B, C, D, Observable<E>> four,
            final Func5<A, B, C, D, E, Observable<F>> five,
            final Func6<A, B, C, D, E, F, Observable<R>> six) {
        return zero.call().flatMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).flatMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).flatMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c).flatMap(new Func1<D, Observable<R>>() {
                                    @Override
                                    public Observable<R> call(final D d) {
                                        return four.call(a, b, c, d).flatMap(new Func1<E, Observable<R>>() {
                                            @Override
                                            public Observable<R> call(final E e) {
                                                return five.call(a, b, c, d, e).flatMap(new Func1<F, Observable<R>>() {
                                                    @Override
                                                    public Observable<R> call(final F f) {
                                                        return six.call(a, b, c, d, e, f);
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
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#flatMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, R> Observable<R> doFlatMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<D>> three,
            final Func4<A, B, C, D, Observable<E>> four,
            final Func5<A, B, C, D, E, Observable<F>> five,
            final Func6<A, B, C, D, E, F, Observable<G>> six,
            final Func7<A, B, C, D, E, F, G, Observable<R>> seven) {
        return zero.call().flatMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).flatMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).flatMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c).flatMap(new Func1<D, Observable<R>>() {
                                    @Override
                                    public Observable<R> call(final D d) {
                                        return four.call(a, b, c, d).flatMap(new Func1<E, Observable<R>>() {
                                            @Override
                                            public Observable<R> call(final E e) {
                                                return five.call(a, b, c, d, e).flatMap(new Func1<F, Observable<R>>() {
                                                    @Override
                                                    public Observable<R> call(final F f) {
                                                        return six.call(a, b, c, d, e, f).flatMap(new Func1<G, Observable<R>>() {
                                                            @Override
                                                            public Observable<R> call(final G g) {
                                                                return seven.call(a, b, c, d, e, f, g);
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
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#flatMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, H, R> Observable<R> doFlatMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<D>> three,
            final Func4<A, B, C, D, Observable<E>> four,
            final Func5<A, B, C, D, E, Observable<F>> five,
            final Func6<A, B, C, D, E, F, Observable<G>> six,
            final Func7<A, B, C, D, E, F, G, Observable<H>> seven,
            final Func8<A, B, C, D, E, F, G, H, Observable<R>> eight) {
        return zero.call().flatMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).flatMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).flatMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c).flatMap(new Func1<D, Observable<R>>() {
                                    @Override
                                    public Observable<R> call(final D d) {
                                        return four.call(a, b, c, d).flatMap(new Func1<E, Observable<R>>() {
                                            @Override
                                            public Observable<R> call(final E e) {
                                                return five.call(a, b, c, d, e).flatMap(new Func1<F, Observable<R>>() {
                                                    @Override
                                                    public Observable<R> call(final F f) {
                                                        return six.call(a, b, c, d, e, f).flatMap(new Func1<G, Observable<R>>() {
                                                            @Override
                                                            public Observable<R> call(final G g) {
                                                                return seven.call(a, b, c, d, e, f, g).flatMap(new Func1<H, Observable<R>>() {
                                                                    @Override
                                                                    public Observable<R> call(final H h) {
                                                                        return eight.call(a, b, c, d, e, f, g, h);
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
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#flatMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, H, I, R> Observable<R> doFlatMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<D>> three,
            final Func4<A, B, C, D, Observable<E>> four,
            final Func5<A, B, C, D, E, Observable<F>> five,
            final Func6<A, B, C, D, E, F, Observable<G>> six,
            final Func7<A, B, C, D, E, F, G, Observable<H>> seven,
            final Func8<A, B, C, D, E, F, G, H, Observable<I>> eight,
            final Func9<A, B, C, D, E, F, G, H, I, Observable<R>> nine) {
        return zero.call().flatMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).flatMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).flatMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c).flatMap(new Func1<D, Observable<R>>() {
                                    @Override
                                    public Observable<R> call(final D d) {
                                        return four.call(a, b, c, d).flatMap(new Func1<E, Observable<R>>() {
                                            @Override
                                            public Observable<R> call(final E e) {
                                                return five.call(a, b, c, d, e).flatMap(new Func1<F, Observable<R>>() {
                                                    @Override
                                                    public Observable<R> call(final F f) {
                                                        return six.call(a, b, c, d, e, f).flatMap(new Func1<G, Observable<R>>() {
                                                            @Override
                                                            public Observable<R> call(final G g) {
                                                                return seven.call(a, b, c, d, e, f, g).flatMap(new Func1<H, Observable<R>>() {
                                                                    @Override
                                                                    public Observable<R> call(final H h) {
                                                                        return eight.call(a, b, c, d, e, f, g, h).flatMap(new Func1<I, Observable<R>>() {
                                                                            @Override
                                                                            public Observable<R> call(final I i) {
                                                                                return nine.call(a, b, c, d, e, f, g, h, i);
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

    /**
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#concatMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, R> Observable<R> doConcatMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<R>> one) {
        return zero.call().concatMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a);
            }
        });
    }

    /**
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#concatMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, R> Observable<R> doConcatMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<R>> two) {
        return zero.call().concatMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).concatMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b);
                    }
                });
            }
        });
    }

    /**
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#concatMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, R> Observable<R> doConcatMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<R>> three) {
        return zero.call().concatMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).concatMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).concatMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c);
                            }
                        });
                    }
                });
            }
        });
    }

    /**
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#concatMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, R> Observable<R> doConcatMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<D>> three,
            final Func4<A, B, C, D, Observable<R>> four) {
        return zero.call().concatMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).concatMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).concatMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c).concatMap(new Func1<D, Observable<R>>() {
                                    @Override
                                    public Observable<R> call(final D d) {
                                        return four.call(a, b, c, d);
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
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#concatMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, R> Observable<R> doConcatMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<D>> three,
            final Func4<A, B, C, D, Observable<E>> four,
            final Func5<A, B, C, D, E, Observable<R>> five) {
        return zero.call().concatMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).concatMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).concatMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c).concatMap(new Func1<D, Observable<R>>() {
                                    @Override
                                    public Observable<R> call(final D d) {
                                        return four.call(a, b, c, d).concatMap(new Func1<E, Observable<R>>() {
                                            @Override
                                            public Observable<R> call(final E e) {
                                                return five.call(a, b, c, d, e);
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
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#concatMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, R> Observable<R> doConcatMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<D>> three,
            final Func4<A, B, C, D, Observable<E>> four,
            final Func5<A, B, C, D, E, Observable<F>> five,
            final Func6<A, B, C, D, E, F, Observable<R>> six) {
        return zero.call().concatMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).concatMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).concatMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c).concatMap(new Func1<D, Observable<R>>() {
                                    @Override
                                    public Observable<R> call(final D d) {
                                        return four.call(a, b, c, d).concatMap(new Func1<E, Observable<R>>() {
                                            @Override
                                            public Observable<R> call(final E e) {
                                                return five.call(a, b, c, d, e).concatMap(new Func1<F, Observable<R>>() {
                                                    @Override
                                                    public Observable<R> call(final F f) {
                                                        return six.call(a, b, c, d, e, f);
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
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#concatMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, R> Observable<R> doConcatMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<D>> three,
            final Func4<A, B, C, D, Observable<E>> four,
            final Func5<A, B, C, D, E, Observable<F>> five,
            final Func6<A, B, C, D, E, F, Observable<G>> six,
            final Func7<A, B, C, D, E, F, G, Observable<R>> seven) {
        return zero.call().concatMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).concatMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).concatMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c).concatMap(new Func1<D, Observable<R>>() {
                                    @Override
                                    public Observable<R> call(final D d) {
                                        return four.call(a, b, c, d).concatMap(new Func1<E, Observable<R>>() {
                                            @Override
                                            public Observable<R> call(final E e) {
                                                return five.call(a, b, c, d, e).concatMap(new Func1<F, Observable<R>>() {
                                                    @Override
                                                    public Observable<R> call(final F f) {
                                                        return six.call(a, b, c, d, e, f).concatMap(new Func1<G, Observable<R>>() {
                                                            @Override
                                                            public Observable<R> call(final G g) {
                                                                return seven.call(a, b, c, d, e, f, g);
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
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#concatMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, H, R> Observable<R> doConcatMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<D>> three,
            final Func4<A, B, C, D, Observable<E>> four,
            final Func5<A, B, C, D, E, Observable<F>> five,
            final Func6<A, B, C, D, E, F, Observable<G>> six,
            final Func7<A, B, C, D, E, F, G, Observable<H>> seven,
            final Func8<A, B, C, D, E, F, G, H, Observable<R>> eight) {
        return zero.call().concatMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).concatMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).concatMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c).concatMap(new Func1<D, Observable<R>>() {
                                    @Override
                                    public Observable<R> call(final D d) {
                                        return four.call(a, b, c, d).concatMap(new Func1<E, Observable<R>>() {
                                            @Override
                                            public Observable<R> call(final E e) {
                                                return five.call(a, b, c, d, e).concatMap(new Func1<F, Observable<R>>() {
                                                    @Override
                                                    public Observable<R> call(final F f) {
                                                        return six.call(a, b, c, d, e, f).concatMap(new Func1<G, Observable<R>>() {
                                                            @Override
                                                            public Observable<R> call(final G g) {
                                                                return seven.call(a, b, c, d, e, f, g).concatMap(new Func1<H, Observable<R>>() {
                                                                    @Override
                                                                    public Observable<R> call(final H h) {
                                                                        return eight.call(a, b, c, d, e, f, g, h);
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
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#concatMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, H, I, R> Observable<R> doConcatMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<D>> three,
            final Func4<A, B, C, D, Observable<E>> four,
            final Func5<A, B, C, D, E, Observable<F>> five,
            final Func6<A, B, C, D, E, F, Observable<G>> six,
            final Func7<A, B, C, D, E, F, G, Observable<H>> seven,
            final Func8<A, B, C, D, E, F, G, H, Observable<I>> eight,
            final Func9<A, B, C, D, E, F, G, H, I, Observable<R>> nine) {
        return zero.call().concatMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).concatMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).concatMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c).concatMap(new Func1<D, Observable<R>>() {
                                    @Override
                                    public Observable<R> call(final D d) {
                                        return four.call(a, b, c, d).concatMap(new Func1<E, Observable<R>>() {
                                            @Override
                                            public Observable<R> call(final E e) {
                                                return five.call(a, b, c, d, e).concatMap(new Func1<F, Observable<R>>() {
                                                    @Override
                                                    public Observable<R> call(final F f) {
                                                        return six.call(a, b, c, d, e, f).concatMap(new Func1<G, Observable<R>>() {
                                                            @Override
                                                            public Observable<R> call(final G g) {
                                                                return seven.call(a, b, c, d, e, f, g).concatMap(new Func1<H, Observable<R>>() {
                                                                    @Override
                                                                    public Observable<R> call(final H h) {
                                                                        return eight.call(a, b, c, d, e, f, g, h).concatMap(new Func1<I, Observable<R>>() {
                                                                            @Override
                                                                            public Observable<R> call(final I i) {
                                                                                return nine.call(a, b, c, d, e, f, g, h, i);
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

    /**
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#switchMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, R> Observable<R> doSwitchMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<R>> one) {
        return zero.call().switchMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a);
            }
        });
    }

    /**
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#switchMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, R> Observable<R> doSwitchMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<R>> two) {
        return zero.call().switchMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).switchMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b);
                    }
                });
            }
        });
    }

    /**
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#switchMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, R> Observable<R> doSwitchMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<R>> three) {
        return zero.call().switchMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).switchMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).switchMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c);
                            }
                        });
                    }
                });
            }
        });
    }

    /**
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#switchMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, R> Observable<R> doSwitchMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<D>> three,
            final Func4<A, B, C, D, Observable<R>> four) {
        return zero.call().switchMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).switchMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).switchMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c).switchMap(new Func1<D, Observable<R>>() {
                                    @Override
                                    public Observable<R> call(final D d) {
                                        return four.call(a, b, c, d);
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
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#switchMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, R> Observable<R> doSwitchMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<D>> three,
            final Func4<A, B, C, D, Observable<E>> four,
            final Func5<A, B, C, D, E, Observable<R>> five) {
        return zero.call().switchMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).switchMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).switchMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c).switchMap(new Func1<D, Observable<R>>() {
                                    @Override
                                    public Observable<R> call(final D d) {
                                        return four.call(a, b, c, d).switchMap(new Func1<E, Observable<R>>() {
                                            @Override
                                            public Observable<R> call(final E e) {
                                                return five.call(a, b, c, d, e);
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
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#switchMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, R> Observable<R> doSwitchMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<D>> three,
            final Func4<A, B, C, D, Observable<E>> four,
            final Func5<A, B, C, D, E, Observable<F>> five,
            final Func6<A, B, C, D, E, F, Observable<R>> six) {
        return zero.call().switchMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).switchMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).switchMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c).switchMap(new Func1<D, Observable<R>>() {
                                    @Override
                                    public Observable<R> call(final D d) {
                                        return four.call(a, b, c, d).switchMap(new Func1<E, Observable<R>>() {
                                            @Override
                                            public Observable<R> call(final E e) {
                                                return five.call(a, b, c, d, e).switchMap(new Func1<F, Observable<R>>() {
                                                    @Override
                                                    public Observable<R> call(final F f) {
                                                        return six.call(a, b, c, d, e, f);
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
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#switchMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, R> Observable<R> doSwitchMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<D>> three,
            final Func4<A, B, C, D, Observable<E>> four,
            final Func5<A, B, C, D, E, Observable<F>> five,
            final Func6<A, B, C, D, E, F, Observable<G>> six,
            final Func7<A, B, C, D, E, F, G, Observable<R>> seven) {
        return zero.call().switchMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).switchMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).switchMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c).switchMap(new Func1<D, Observable<R>>() {
                                    @Override
                                    public Observable<R> call(final D d) {
                                        return four.call(a, b, c, d).switchMap(new Func1<E, Observable<R>>() {
                                            @Override
                                            public Observable<R> call(final E e) {
                                                return five.call(a, b, c, d, e).switchMap(new Func1<F, Observable<R>>() {
                                                    @Override
                                                    public Observable<R> call(final F f) {
                                                        return six.call(a, b, c, d, e, f).switchMap(new Func1<G, Observable<R>>() {
                                                            @Override
                                                            public Observable<R> call(final G g) {
                                                                return seven.call(a, b, c, d, e, f, g);
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
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#switchMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, H, R> Observable<R> doSwitchMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<D>> three,
            final Func4<A, B, C, D, Observable<E>> four,
            final Func5<A, B, C, D, E, Observable<F>> five,
            final Func6<A, B, C, D, E, F, Observable<G>> six,
            final Func7<A, B, C, D, E, F, G, Observable<H>> seven,
            final Func8<A, B, C, D, E, F, G, H, Observable<R>> eight) {
        return zero.call().switchMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).switchMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).switchMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c).switchMap(new Func1<D, Observable<R>>() {
                                    @Override
                                    public Observable<R> call(final D d) {
                                        return four.call(a, b, c, d).switchMap(new Func1<E, Observable<R>>() {
                                            @Override
                                            public Observable<R> call(final E e) {
                                                return five.call(a, b, c, d, e).switchMap(new Func1<F, Observable<R>>() {
                                                    @Override
                                                    public Observable<R> call(final F f) {
                                                        return six.call(a, b, c, d, e, f).switchMap(new Func1<G, Observable<R>>() {
                                                            @Override
                                                            public Observable<R> call(final G g) {
                                                                return seven.call(a, b, c, d, e, f, g).switchMap(new Func1<H, Observable<R>>() {
                                                                    @Override
                                                                    public Observable<R> call(final H h) {
                                                                        return eight.call(a, b, c, d, e, f, g, h);
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
     * Composes an {@link rx.Observable} from multiple creation functions chained by {@link Observable#switchMap(Func1)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, H, I, R> Observable<R> doSwitchMap(
            final Func0<Observable<A>> zero,
            final Func1<A, Observable<B>> one,
            final Func2<A, B, Observable<C>> two,
            final Func3<A, B, C, Observable<D>> three,
            final Func4<A, B, C, D, Observable<E>> four,
            final Func5<A, B, C, D, E, Observable<F>> five,
            final Func6<A, B, C, D, E, F, Observable<G>> six,
            final Func7<A, B, C, D, E, F, G, Observable<H>> seven,
            final Func8<A, B, C, D, E, F, G, H, Observable<I>> eight,
            final Func9<A, B, C, D, E, F, G, H, I, Observable<R>> nine) {
        return zero.call().switchMap(new Func1<A, Observable<R>>() {
            @Override
            public Observable<R> call(final A a) {
                return one.call(a).switchMap(new Func1<B, Observable<R>>() {
                    @Override
                    public Observable<R> call(final B b) {
                        return two.call(a, b).switchMap(new Func1<C, Observable<R>>() {
                            @Override
                            public Observable<R> call(final C c) {
                                return three.call(a, b, c).switchMap(new Func1<D, Observable<R>>() {
                                    @Override
                                    public Observable<R> call(final D d) {
                                        return four.call(a, b, c, d).switchMap(new Func1<E, Observable<R>>() {
                                            @Override
                                            public Observable<R> call(final E e) {
                                                return five.call(a, b, c, d, e).switchMap(new Func1<F, Observable<R>>() {
                                                    @Override
                                                    public Observable<R> call(final F f) {
                                                        return six.call(a, b, c, d, e, f).switchMap(new Func1<G, Observable<R>>() {
                                                            @Override
                                                            public Observable<R> call(final G g) {
                                                                return seven.call(a, b, c, d, e, f, g).switchMap(new Func1<H, Observable<R>>() {
                                                                    @Override
                                                                    public Observable<R> call(final H h) {
                                                                        return eight.call(a, b, c, d, e, f, g, h).switchMap(new Func1<I, Observable<R>>() {
                                                                            @Override
                                                                            public Observable<R> call(final I i) {
                                                                                return nine.call(a, b, c, d, e, f, g, h, i);
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

    /**
     * Composes an {@link rx.Observable} from multiple {@link Transformer} chained by {@link Observable#compose(Transformer)}.
     *
     * @return composed Observable
     */
    public static <A, R> Observable<R> doCompose(
            final Func0<Observable<A>> zero,
            final Transformer<A, R> one) {
        return zero.call()
                .compose(one);
    }

    /**
     * Composes an {@link rx.Observable} from multiple {@link Transformer} chained by {@link Observable#compose(Transformer)}.
     *
     * @return composed Observable
     */
    public static <A, B, R> Observable<R> doCompose(
            final Func0<Observable<A>> zero,
            final Transformer<A, B> one,
            final Transformer<B, R> two) {
        return zero.call()
                .compose(one)
                .compose(two);
    }

    /**
     * Composes an {@link rx.Observable} from multiple {@link Transformer} chained by {@link Observable#compose(Transformer)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, R> Observable<R> doCompose(
            final Func0<Observable<A>> zero,
            final Transformer<A, B> one,
            final Transformer<B, C> two,
            final Transformer<C, R> three) {
        return zero.call()
                .compose(one)
                .compose(two)
                .compose(three);
    }

    /**
     * Composes an {@link rx.Observable} from multiple {@link Transformer} chained by {@link Observable#compose(Transformer)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, R> Observable<R> doCompose(
            final Func0<Observable<A>> zero,
            final Transformer<A, B> one,
            final Transformer<B, C> two,
            final Transformer<C, D> three,
            final Transformer<D, R> four) {
        return zero.call()
                .compose(one)
                .compose(two)
                .compose(three)
                .compose(four);
    }

    /**
     * Composes an {@link rx.Observable} from multiple {@link Transformer} chained by {@link Observable#compose(Transformer)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, R> Observable<R> doCompose(
            final Func0<Observable<A>> zero,
            final Transformer<A, B> one,
            final Transformer<B, C> two,
            final Transformer<C, D> three,
            final Transformer<D, E> four,
            final Transformer<E, R> five) {
        return zero.call()
                .compose(one)
                .compose(two)
                .compose(three)
                .compose(four)
                .compose(five);
    }

    /**
     * Composes an {@link rx.Observable} from multiple {@link Transformer} chained by {@link Observable#compose(Transformer)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, R> Observable<R> doCompose(
            final Func0<Observable<A>> zero,
            final Transformer<A, B> one,
            final Transformer<B, C> two,
            final Transformer<C, D> three,
            final Transformer<D, E> four,
            final Transformer<E, F> five,
            final Transformer<F, R> six) {
        return zero.call()
                .compose(one)
                .compose(two)
                .compose(three)
                .compose(four)
                .compose(five)
                .compose(six);
    }

    /**
     * Composes an {@link rx.Observable} from multiple {@link Transformer} chained by {@link Observable#compose(Transformer)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, R> Observable<R> doCompose(
            final Func0<Observable<A>> zero,
            final Transformer<A, B> one,
            final Transformer<B, C> two,
            final Transformer<C, D> three,
            final Transformer<D, E> four,
            final Transformer<E, F> five,
            final Transformer<F, G> six,
            final Transformer<G, R> seven) {
        return zero.call()
                .compose(one)
                .compose(two)
                .compose(three)
                .compose(four)
                .compose(five)
                .compose(six)
                .compose(seven);
    }

    /**
     * Composes an {@link rx.Observable} from multiple {@link Transformer} chained by {@link Observable#compose(Transformer)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, H, R> Observable<R> doCompose(
            final Func0<Observable<A>> zero,
            final Transformer<A, B> one,
            final Transformer<B, C> two,
            final Transformer<C, D> three,
            final Transformer<D, E> four,
            final Transformer<E, F> five,
            final Transformer<F, G> six,
            final Transformer<G, H> seven,
            final Transformer<H, R> eight) {
        return zero.call()
                .compose(one)
                .compose(two)
                .compose(three)
                .compose(four)
                .compose(five)
                .compose(six)
                .compose(seven)
                .compose(eight);
    }

    /**
     * Composes an {@link rx.Observable} from multiple {@link Transformer} chained by {@link Observable#compose(Transformer)}.
     *
     * @return composed Observable
     */
    public static <A, B, C, D, E, F, G, H, I, R> Observable<R> doCompose(
            final Func0<Observable<A>> zero,
            final Transformer<A, B> one,
            final Transformer<B, C> two,
            final Transformer<C, D> three,
            final Transformer<D, E> four,
            final Transformer<E, F> five,
            final Transformer<F, G> six,
            final Transformer<G, H> seven,
            final Transformer<H, I> eight,
            final Transformer<I, R> nine) {
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
    }
}
