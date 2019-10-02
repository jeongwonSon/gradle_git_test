package com.example.demo.thread;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SleepTest {

    /**
     * 2019.10.02
     * thread.sleep 확인 test
     *
     * 솔루션2(orderServiceImpl :: 4582)
     * 실시간 계좌이체 방식을 temp 테이블에 통신받은 값을 저장 후, 주문등록 시 해당 temp 테이블에
     * 값이 있는지 없는 지 여부를 따져서 주문등록을 함
     * (temp 테이블에 값이 있는지 없는지 thread.sleep(1000)을 걸어서 계속 확인함)
     *
     * (thread에 관한 개념이 부족해서 한번 찾아볼 것)
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        int num = 100;

        // 시간 출력 포맷
        SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");

        for (int i=0; i < num ; i++) {
            Calendar cal = Calendar.getInstance();

            // 콘솔에 출력 (현재시간 + i)
            System.out.println(fmt.format(cal.getTime()) + "=" + i);

            // 1초간 중지시킴 (단위 : ms)
            Thread.sleep(1000);
        }

    }
}
