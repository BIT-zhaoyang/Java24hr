package io.zhaoyang.java24hr.lesson17;

public class Demo{
    public static void main(String[] args){
        MyThread my1 = new MyThread();
        MyThread my2 = new MyThread();
        // 启动线程
        my1.start();
        my2.start();
    }
}

class MyThread extends Thread {//定义了一个线程主体类
    private static int ticket=10;
    private String name;
    public MyThread() {
    }
    public MyThread(String name) {
        this.name=name;
    }
    @Override
    public void run() {//定义了线程的run方法
        for(int i=0;i<10;i++){
            if(this.ticket>0){
              System.out.println(this.name+"正在出售倒数第："+this.ticket--+"张票");
            }
        }
    }
}


