package ex2;
import java.util.concurrent.Semaphore;

public class FizzBuzz {

    private int n;
    private int currentNumber = 1;
    private Semaphore semaphore = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz() throws InterruptedException {
        while (currentNumber <= n) {
            semaphore.acquire();
            if (currentNumber % 3 == 0 && currentNumber % 5 != 0) {
                System.out.println("fizz");
                currentNumber++;
            }
            semaphore.release();
        }
    }

    public void buzz() throws InterruptedException {
        while (currentNumber <= n) {
            semaphore.acquire();
            if (currentNumber % 5 == 0 && currentNumber % 3 != 0) {
                System.out.println("buzz");
                currentNumber++;
            }
            semaphore.release();
        }
    }

    public void fizzbuzz() throws InterruptedException {
        while (currentNumber <= n) {
            semaphore.acquire();
            if (currentNumber % 3 == 0 && currentNumber % 5 == 0) {
                System.out.println("fizzbuzz");
                currentNumber++;
            }
            semaphore.release();
        }
    }

    public void number() throws InterruptedException {
        while (currentNumber <= n) {
            semaphore.acquire();
            if (currentNumber % 3 != 0 && currentNumber % 5 != 0) {
                System.out.println(currentNumber);
                currentNumber++;
            }
            semaphore.release();
        }
    }


}
