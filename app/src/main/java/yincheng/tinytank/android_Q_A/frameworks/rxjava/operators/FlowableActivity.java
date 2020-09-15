package yincheng.tinytank.android_Q_A.frameworks.rxjava.operators;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import yincheng.tinytank.R;

public class FlowableActivity extends AppCompatActivity {
	private static final String TAG = "FlowableActivity";

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one_button);

//		//region 1
//		/*
//		 * 本例是一个同步订阅，如果在同步订阅中没有s.request(Long.MAX_VALUE);
//		 * 上游就认为下游没有处理事件的能力，因此会在发送完1之后抛出如下异常：
//		 * io.reactivex.exceptions.MissingBackpressureException: create: could not
//		 * emit value due to lack of requests
//		 * 后续事件也能继续发送完毕。
//		 */
//		Flowable
//				.create(new FlowableOnSubscribe<Integer>() {
//					@Override
//					public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
//						Log.d(TAG, "emit:1");
//						emitter.onNext(1);
//						Log.d(TAG, "emit:2");
//						emitter.onNext(2);
//						Log.d(TAG, "emit:3");
//						emitter.onNext(3);
//						Log.d(TAG, "emit:onComplete");
//						emitter.onComplete();
//					}
//				}, BackpressureStrategy.ERROR)
//				.subscribe(new Subscriber<Integer>() {
//
//					@Override
//					public void onSubscribe(Subscription s) {
//						Log.d(TAG, "onSubscribe");
//						s.request(Long.MAX_VALUE);
//					}
//
//					@Override
//					public void onNext(Integer integer) {
//						Log.d(TAG, "onNext: " + integer);
//					}
//
//					@Override
//					public void onError(Throwable t) {
//						Log.w(TAG, "onError: ", t);
//					}
//
//					@Override
//					public void onComplete() {
//						Log.d(TAG, "onComplete");
//					}
//				});
//		/**
//		 * onSubscribe
//		 * emit:1
//		 * onNext: 1
//		 * emit:2
//		 * onNext: 2
//		 * emit:3
//		 * onNext: 3
//		 * emit:onComplete
//		 * onComplete
//		 */
//		//endregion


//		//region 2
//		/*
//		 * 本例是一个异步订阅（发送和接收消息发生在不同线程），因此虽然没有s.request(Long.MAX_VALUE)，
//		 * 但也能正常发送消息，只是收不到消息。
//		 */
//		Flowable
//				.create(new FlowableOnSubscribe<Integer>() {
//					@Override
//					public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
//						Log.d(TAG, "emit:1");
//						emitter.onNext(1);
//						Log.d(TAG, "emit:2");
//						emitter.onNext(2);
//						Log.d(TAG, "emit:3");
//						emitter.onNext(3);
//						Log.d(TAG, "emit:onComplete");
//						emitter.onComplete();
//					}
//				}, BackpressureStrategy.ERROR)
//				.subscribeOn(Schedulers.io())
//				.observeOn(AndroidSchedulers.mainThread())
//				.subscribe(new Subscriber<Integer>() {
//
//					@Override
//					public void onSubscribe(Subscription s) {
//						Log.d(TAG, "onSubscribe");
//					}
//
//					@Override
//					public void onNext(Integer integer) {
//						Log.d(TAG, "onNext: " + integer);
//					}
//
//					@Override
//					public void onError(Throwable t) {
//						Log.w(TAG, "onError: ", t);
//					}
//
//					@Override
//					public void onComplete() {
//						Log.d(TAG, "onComplete");
//					}
//				});
//		//endregion

//		//region 3
//		/*
//		 * 在同步订阅中，可以从emitter获取到下游可以处理的事件数量，设置的多少就是多少
//		 * 而如果改为异步订阅（添加subscribeOn和ObserveOn方法），则获取到的下游可以处理的事件的数量为
//		 * 默认的128，因此在本例中就会发送128个事件，但是处理的时候只会处理10个，因为request了10个。
//		 */
//		Flowable
//				.create(new FlowableOnSubscribe<Integer>() {
//					@Override
//					public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
//						// 调用emitter.requested()获取当前观察者需要接收的事件数量
//						long n = emitter.requested();
//						Log.d(TAG, "观察者可接收事件" + n);
//						// 根据emitter.requested()的值，即当前观察者需要接收的事件数量来发送事件
//						for (int i = 0; i < n; i++) {
//							Log.d(TAG, "发送了事件" + i);
//							emitter.onNext(i);
//						}
//					}
//				}, BackpressureStrategy.ERROR)
//				.subscribeOn(Schedulers.io())
//				.observeOn(AndroidSchedulers.mainThread())
//				.subscribe(new Subscriber<Integer>() {
//					@Override
//					public void onSubscribe(Subscription s) {
//						Log.d(TAG, "onSubscribe");
//						// 设置观察者每次能接受10个事件
//						s.request(10);
//					}
//
//					@Override
//					public void onNext(Integer integer) {
//						Log.d(TAG, "接收到了事件" + integer);
//					}
//
//					@Override
//					public void onError(Throwable t) {
//						Log.w(TAG, "onError: ", t);
//					}
//
//					@Override
//					public void onComplete() {
//						Log.d(TAG, "onComplete");
//					}
//				});
//		//endregion

//		//region 4
//		/*
//		 * 本例是一个异步订阅，同步订阅的话就失去了意义，因为同步订阅总是在处理完成一个事件之后
//		 * 才能发送下一个事件的
//		 * BackpressureStrategy.LATEST
//		 * 下游可以处理129个事件，但是上游发送了150个事件，因此在发送了129个事件之后，
//		 * 在发送的事件会替换掉第129个事件，因此最后收到的事件是1到128和150这129个数字
//		 */
//		final Subscription[] mSubscription = new Subscription[1];
//		Flowable
//				.create(new FlowableOnSubscribe<Integer>() {
//					@Override
//					public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
//						// 发送 150个事件
//						for (int i = 1; i <= 150; i++) {
//							Log.d(TAG, "发送了事件" + i);
//							emitter.onNext(i);
//						}
//						emitter.onComplete();
//					}
//				}, BackpressureStrategy.LATEST) // 设置背压模式 = BackpressureStrategy.LATEST
//				.subscribeOn(Schedulers.io())
//				.observeOn(AndroidSchedulers.mainThread())
//				.subscribe(new Subscriber<Integer>() {
//					@Override
//					public void onSubscribe(Subscription s) {
//						Log.d(TAG, "onSubscribe");
//						mSubscription[0] = s;
//						s.request(129);
//						// 设置
//					}
//
//					@Override
//					public void onNext(Integer integer) {
//						Log.d(TAG, "接收到了事件" + integer);
//					}
//
//					@Override
//					public void onError(Throwable t) {
//						Log.w(TAG, "onError: ", t);
//					}
//
//					@Override
//					public void onComplete() {
//						Log.d(TAG, "onComplete");
//					}
//				});
//
//		findViewById(R.id.btnStart)
//				.setOnClickListener(new View.OnClickListener() {
//					@Override
//					public void onClick(View view) {
//						mSubscription[0].request(1);
//					}
//				});
//		//endregion
//
//		//region 5
//		final Subscription[] mSubscription = new Subscription[1];
//		Flowable
//				.create(new FlowableOnSubscribe<Integer>() {
//					@Override
//					public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
//						Log.d(TAG, "观察者可接收事件数量 = " + emitter.requested());
//						boolean flag;
//						// 被观察者一共需要发送500个事件
//						for (int i = 0; i < 500; i++) {
//							flag = false;
//
//							// 若requested() == 0则不发送
//							while (emitter.requested() == 0) {
//								if (!flag) {
//									Log.d(TAG, "不再发送");
//									flag = true;
//								}
//							}
//							Log.d(TAG, "发送了事件" + i + "，观察者可接收事件数量 = " + emitter.requested());
//							emitter.onNext(i);
//						}
//					}
//				}, BackpressureStrategy.ERROR)
//				.subscribeOn(Schedulers.io())
//				.observeOn(AndroidSchedulers.mainThread())
//				.subscribe(new Subscriber<Integer>() {
//					@Override
//					public void onSubscribe(Subscription s) {
//						Log.d(TAG, "onSubscribe");
//						mSubscription[0] = s;
//						// 初始状态 = 不接收事件；通过点击按钮接收事件
//					}
//
//					@Override
//					public void onNext(Integer integer) {
//						Log.d(TAG, "接收到了事件" + integer);
//					}
//
//					@Override
//					public void onError(Throwable t) {
//						Log.w(TAG, "onError: ", t);
//					}
//
//					@Override
//					public void onComplete() {
//						Log.d(TAG, "onComplete");
//					}
//				});
//
//		findViewById(R.id.btnStart)
//				.setOnClickListener(new View.OnClickListener() {
//					@Override
//					public void onClick(View view) {
//						mSubscription[0].request(48);
//						// 点击按钮 则 接收48个事件
//					}
//				});
//		//endregion

//
//
//        Flowable.create(new FlowableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
//
//                Log.d(TAG, "观察者可接收事件数量 = " + emitter.requested());
//                    boolean flag;
//
//                    // 被观察者一共需要发送500个事件
//                    for (int i = 0; i < 500; i++) {
//                        flag = false;
//
//                        // 若requested() == 0则不发送
//                        while (emitter.requested() == 0) {
//                            if (!flag) {
//                                Log.d(TAG, "不再发送");
//                                flag = true;
//                            }
//                        }
//                        Log.d(TAG, "发送了事件" + i + "，观察者可接收事件数量 = " + emitter.requested());
//                        emitter.onNext(i);
//
//
//                }
//            }
//        }, BackpressureStrategy.ERROR).subscribeOn(Schedulers.io()) // 设置被观察者在io线程中进行
//                .observeOn(AndroidSchedulers.mainThread()) // 设置观察者在主线程中进行
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "onSubscribe");
//                        mSubscription = s;
//                       // 初始状态 = 不接收事件；通过点击按钮接收事件
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "接收到了事件" + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.w(TAG, "onError: ", t);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete");
//                    }
//                });
//
//
//		/**
//		 * （同步）控制上游方法： FlowableEmitter
//		 */
//        Flowable.create(new FlowableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
//
//                 1. 调用emitter.requested()获取当前观察者需要接收的事件数量
//                Log.d(TAG, "观察者可接收事件数量 = " + emitter.requested());
//
//                // 2. 每次发送事件后，emitter.requested()会实时更新观察者能接受的事件
//                // 即一开始观察者要接收10个事件，发送了1个后，会实时更新为9个
//                Log.d(TAG, "发送了事件 1");
//                emitter.onNext(1);
//                Log.d(TAG, "发送了事件1后, 还需要发送事件数量 = " + emitter.requested());
//
//                Log.d(TAG, "发送了事件 2");
//                emitter.onNext(2);
//                Log.d(TAG, "发送事件2后, 还需要发送事件数量 = " + emitter.requested());
//
////                Log.d(TAG, "发送了事件 3");
////                emitter.onNext(3);
////                Log.d(TAG, "发送事件3后, 还需要发送事件数量 = " + emitter.requested());
//
//                emitter.onComplete();
//            }
//        }, BackpressureStrategy.ERROR)
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "onSubscribe");
//                        s.request(1); // 设置观察者每次能接受10个事件
////                        s.request(20); // 第2次设置观察者每次能接受20个事件
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "接收到了事件" + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.w(TAG, "onError: ", t);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete");
//                    }
//                });


		/**
		 * 调用RxJava封装好的背压模式方法
		 */

//        Flowable.interval(1, TimeUnit.MILLISECONDS)
//                .onBackpressureBuffer() // 添加背压策略封装好的方法，此处选择Buffer模式，即缓存区大小无限制
//                .observeOn(Schedulers.newThread())
//                .subscribe(new Subscriber<Long>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "onSubscribe");
//                        mSubscription = s;
//                        s.request(Long.MAX_VALUE);
//                    }
//
//                    @Override
//                    public void onNext(Long aLong) {
//                        Log.d(TAG, "onNext: " + aLong);
//                        try {
//                            Thread.sleep(1000);
//
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.w(TAG, "onError: ", t);
//                    }
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete");
//                    }
//                });

//
//        // 通过interval自动创建被观察者Flowable
//        // 每隔1ms将当前数字（从0开始）加1，并发送出去
//        // interval操作符会默认新开1个新的工作线程
//        Flowable.interval(1, TimeUnit.MILLISECONDS)
//                .onBackpressureBuffer() // 添加背压策略封装好的方法，此处选择Buffer模式，即缓存区大小无限制
//                .observeOn(Schedulers.newThread()) // 观察者同样工作在一个新开线程中
//                .subscribe(new Subscriber<Long>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "onSubscribe");
//                        mSubscription = s;
//                        s.request(Long.MAX_VALUE); //默认可以接收Long.MAX_VALUE个事件
//                    }
//
//                    @Override
//                    public void onNext(Long aLong) {
//                        Log.d(TAG, "onNext: " + aLong);
//                        try {
//                            Thread.sleep(1000);
//                            // 每次延时1秒再接收事件
//                            // 因为发送事件 = 延时1ms，接收事件 = 延时1s，出现了发送速度 & 接收速度不匹配的问题
//                            // 缓存区很快就存满了128个事件，从而抛出MissingBackpressureException异常
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.w(TAG, "onError: ", t);
//                    }
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete");
//                    }
//                });


		/**
		 * 测试各种背压模式
		 */

//        btn = (Button) findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mSubscription.request(128);
//                // 每次接收128个事件
//            }
//
//        });
//
//        Flowable.create(new FlowableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
//                for (int i = 0;i< 150; i++) {
//                    Log.d(TAG, "发送了事件" + i);
//                    emitter.onNext(i);
//                }
//                emitter.onComplete();
//            }
//        }, BackpressureStrategy.LATEST).subscribeOn(Schedulers.io()) // 设置被观察者在io线程中进行
//                .observeOn(AndroidSchedulers.mainThread()) // 设置观察者在主线程中进行
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "onSubscribe");
//                        mSubscription = s;
//                        // 通过按钮进行接收事件
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "接收到了事件" + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.w(TAG, "onError: ", t);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete");
//                    }
//                });


		/**
		 * 异步调用
		 */


//        btn = (Button) findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mSubscription.request(2);
//            }
//
//        });
//        Flowable.create(new FlowableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
//                for (int i = 0;i< 129; i++) {
//                    Log.d(TAG, "发送了事件" + i);
//                    emitter.onNext(i);
//                }
//
////                Log.d(TAG, "发送事件 1");
////                emitter.onNext(1);
////                Log.d(TAG, "发送事件 2");
////                emitter.onNext(2);
////                Log.d(TAG, "发送事件 3");
////                emitter.onNext(3);
////                Log.d(TAG, "发送事件 4");
////                emitter.onNext(4);
////                Log.d(TAG, "发送完成");
//                emitter.onComplete();
//            }
//        }, BackpressureStrategy.ERROR).subscribeOn(Schedulers.io()) // 设置被观察者在io线程中进行
//                .observeOn(AndroidSchedulers.mainThread()) // 设置观察者在主线程中进行
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "onSubscribe");
//                        mSubscription = s;
//                        // 保存Subscription对象，等待点击按钮时（调用request(2)）观察者再接收事件
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "接收到了事件" + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.w(TAG, "onError: ", t);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete");
//                    }
//                });


		/**
		 * 同步情况
		 */

//        /**
//         * 步骤1：创建被观察者 =  Flowable
//         */
//        Flowable<Integer> upstream = Flowable.create(new FlowableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
//
//                // 发送4个事件
//                Log.d(TAG, "发送了事件1");
//                emitter.onNext(1);
//                Log.d(TAG, "发送了事件2");
//                emitter.onNext(2);
//                Log.d(TAG, "发送了事件3");
//                emitter.onNext(3);
//                Log.d(TAG, "发送了事件4");
//                emitter.onNext(4);
//                emitter.onComplete();
//            }
//        }, BackpressureStrategy.ERROR);
//
//        /**
//         * 步骤2：创建观察者 =  Subscriber
//         */
//        Subscriber<Integer> downstream = new Subscriber<Integer>() {
//
//            @Override
//            public void onSubscribe(Subscription s) {
//                Log.d(TAG, "onSubscribe");
//                 s.request(3);
//                 // 每次可接收事件 = 3 ，即不匹配
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                Log.d(TAG, "接收到了事件 " + integer);
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                Log.w(TAG, "onError: ", t);
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onComplete");
//            }
//        };
//
//        /**
//         * 步骤3：建立订阅关系
//         */
//        upstream.subscribe(downstream);


		/**
		 * 初步使用Demo
		 */
//        /**
//         * 步骤1：创建被观察者 =  Flowable
//         */
//        Flowable<Integer> upstream = Flowable.create(new FlowableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
//                emitter.onNext(1);
//                emitter.onNext(2);
//                emitter.onNext(3);
//                emitter.onComplete();
//            }
//        }, BackpressureStrategy.ERROR);
//        // 对比Observable，增加了1个参数BackpressureStrategy
//        // 作用：选择背压模式，即决定了当消费事件 与 生产事件速度不匹配时该如何处理的模式
//        // 模式说明：
//                  // BackpressureStrategy.ERROR：当出现消费事件 与 生产事件速度不匹配时，直接抛出异常
//
//        /**
//         * 步骤2：创建观察者 =  Subscriber
//         */
//        Subscriber<Integer> downstream = new Subscriber<Integer>() {
//
//            @Override
//            public void onSubscribe(Subscription s) {
//                // 对比Observer传入的Disposable参数，Subscriber此处传入的参数 = Subscription
//                // 相同点：Subscription具备Disposable参数的作用，即Disposable.dispose()切断连接, 同样的调用Subscription.cancel()切断连接
//                // 不同点：Subscription增加了void request(long n)，下面详细讲解
//
//                Log.d(TAG, "onSubscribe");
//                s.request(Long.MAX_VALUE);
//                // 作用：决定观察者能够接收多少个事件，从而决定被观察者能够发送多少个事件，从而解决观察者 & 被观察者速度不匹配的问题
//                // 如设置了s.request(20)，这就说明观察者能够接收20个事件，然后被观察者只会发送20个事件给观察者处理，从而解决速度匹配问题
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                Log.d(TAG, "onNext: " + integer);
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                Log.w(TAG, "onError: ", t);
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onComplete");
//            }
//        };
//
//        /**
//         * 步骤3：建立订阅关系
//         */
//        upstream.subscribe(downstream);


		/**
		 * 链式调用
		 */
//        Flowable.create(new FlowableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
//                Log.d(TAG, "发送事件 1");
//                emitter.onNext(1);
//                Log.d(TAG, "发送事件 2");
//                emitter.onNext(2);
//                Log.d(TAG, "发送事件 3");
//                emitter.onNext(3);
//                Log.d(TAG, "发送完成");
//                emitter.onComplete();
//            }
//        }, BackpressureStrategy.ERROR)
//                .subscribe(new Subscriber<Integer>() {
//
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "onSubscribe");
//                        s.request(30);
////                        mSubscription = s;  //把Subscription保存起来
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "接收到了事件" + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.w(TAG, "onError: ", t);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete");
//                    }
//                });

//}
//}
	}

}
