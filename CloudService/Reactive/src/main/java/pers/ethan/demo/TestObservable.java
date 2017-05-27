package pers.ethan.demo;

import rx.Observable;
import rx.Subscriber;

/**
 * desc:
 * Created by huangzhe on 2017/4/23.
 */
public class TestObservable {
    public static void main(String[] args) {
        hello(-1,4,5,0,2,19,6);
        hello("Echo", "Ethan", "King");
    }

    public static void hello(Integer... integers) {
        Observable<Integer> workflow = Observable.from(integers)
                .filter( i -> (i < 10) && (i > 0))
                .map( i -> i *2);
        workflow.subscribe(i -> System.out.print(i + "! ") );
    }

    public static void hello(String... names) {
        Observable.from(names).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("Completed!");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error...........");
                throwable.printStackTrace();
            }

            @Override
            public void onNext(String strings) {
                System.out.println("same hello " + strings);
                if ("Ethan".equals(strings)) {
                    int i = 1/0;
                }
            }

        });
    }
}
