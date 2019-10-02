package com.example.demo.thread;

import ch.qos.logback.core.CoreConstants;

/**
 * 해당 소스 참고 :: http://tcpschool.com/java/java_thread_concept
 *
 */
class ThreadWithClass extends Thread {

    public void run() {
        for (int i = 0 ; i < 5 ; i++ ){
            // 현재 실행 중인 스레드의 이름을 반환함
            System.out.println(getName());
            try{
                // 0.01초간 스레드를 멈춤
                Thread.sleep(10);
            } catch (InterruptedException e){
                e.printStackTrace();;
            }
        }
    }
}

class ThreadWithRunnable implements Runnable {
    public void run(){
        for (int i = 0; i < 5 ; i++) {
            // 현재 실행 중인 스레드의 이름을 반환함
            System.out.println(Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class Thread01 {
    public static void main(String[] args){
        // Thread 클래스를 상속받는 방법
        ThreadWithClass thread1 = new ThreadWithClass();
        // Runnable 인터페이스를 구현하는 방법
        Thread thread2 = new Thread(new ThreadWithRunnable());

        thread1.start();
        thread2.start();
    }
}
