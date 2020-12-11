class Foo {
    private Semaphore sp12, sp23;

    public Foo() {
        sp12 = new Semaphore(0);
        sp23 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        sp12.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        sp12.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        sp23.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        sp23.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}