package main;

public class Turnstile extends Thread {

    private final TurnstileCounter counter;
    //This represents the "local" counts done by a specific turnstille instance
    //Not really used in the exercise
    private int count;

    final int COUNT_MAX;
    private String name;

    Turnstile(TurnstileCounter c, int count, String name) {
        counter = c;
        COUNT_MAX = count;
        this.name=name;
        
    }
//Thread har en final getName() der ikke kan overskrives;
    public String getRealName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT_MAX; i++) {
            counter.incr();
            count++;
        }
    }

}
