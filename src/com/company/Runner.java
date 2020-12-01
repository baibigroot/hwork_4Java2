package com.company;

public class Runner extends Thread {

    private Runner beforeRunner;
    private Runner afterRunner;

    Runner(String name) {
        super(name);
    }

    void setRunners(Runner beforeRunner, Runner afterRunner) {
        this.beforeRunner = beforeRunner;
        this.afterRunner = afterRunner;
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " берет палочку ");
            if (getName().equals("Runner5")){
                System.out.println(getName()+ " Бежит к финишу ");
            }
            else {
                System.out.println(getName()+  "Бежит к "+ afterRunner.getName());
                afterRunner.start();
                afterRunner.join();
            }

            if(!getName().equals("Runner1")){
                System.out.println(getName()+ " бежит к "+ beforeRunner.getName());
                System.out.println(beforeRunner.getName() + " берет палочку");
            }
        } catch (Exception ignore) {
        }
    }
}
