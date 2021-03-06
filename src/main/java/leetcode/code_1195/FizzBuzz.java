package leetcode.code_1195;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author：Cheng.
 * @since： 1.0.0
 */
//为什么会时间超时呢？？为什么使用了try catch之后就不会发生时间超时了呢
public class FizzBuzz {

    private int n;

    private int currentNum = 1;
    private Semaphore semaphore = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(;;){//无限循环
            semaphore.acquire(1);
            try{
                //在循环过程中如果打印的字符串个数已经满足要求，那么会使用return来返回，终止该方法的执行
                //但是因为已经获取了信号量，那么在方法返回前需要释放该信号量，否则会导致其他线程一直等待，
                //整个程序一直不结束，使用try-finally可以保证无论如何都会释放信号量，进而使其他线程获得信号量
                if(currentNum > n){
                    return;
                }
                if ((currentNum % 3 == 0) && (currentNum % 5 !=0)){
                    printFizz.run();
                    currentNum++;
                }
            }finally{
                semaphore.release(1);
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(;;){
            semaphore.acquire(1);
            try{
                if(currentNum > n){
                    return;
                }

                if ( (currentNum % 3 != 0) && (currentNum% 5 == 0)){
                    printBuzz.run();
                    currentNum++;
                }
            }finally{
                semaphore.release(1);
            }


        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(;;){
            semaphore.acquire(1);
            try{
                if(currentNum > n){
                    return;
                }

                if ((currentNum % 3 == 0) && (currentNum % 5 ==0)){
                    printFizzBuzz.run();
                    currentNum++;
                }
            }finally{
                semaphore.release(1);
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(;;){
            semaphore.acquire(1);

            try{
                if(currentNum > n){
                    return;
                }

                if ((currentNum % 3 != 0) && (currentNum % 5 !=0)){
                    printNumber.accept(currentNum);
                    currentNum++;
                }
            }finally{
                semaphore.release(1);
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Runnable fizz = () -> System.out.println("fizz");
        Runnable buzz = () -> System.out.println("buzz");
        Runnable fizzbuzz = () -> System.out.println("fizzbuzz");

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(() -> {
            try {
                fizzBuzz.fizz(fizz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        executor.execute(() -> {
            try {
                fizzBuzz.buzz(buzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        executor.execute(() -> {
            try {
                fizzBuzz.fizzbuzz(fizzbuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                fizzBuzz.number(value -> System.out.println(fizzBuzz.currentNum));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}