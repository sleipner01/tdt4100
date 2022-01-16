package stateandbehavior;

public class StopWatch {

    boolean started;
    boolean hasBeenStopped;
    int ticks;
    int thisLapTimeStart;
    int lastLapTime;

    public StopWatch() {
        this.started = false;
        this.hasBeenStopped = false;
        this.ticks = 0;
        this.lastLapTime = -1;
        this.thisLapTimeStart = 0;
    }
    
    public boolean isStarted() {
        return this.started;
    }

    public boolean isStopped() {
        return this.hasBeenStopped;
    }

    public int getTicks() {
        return this.ticks;
    }

    public int getTime() {
        if(this.hasBeenStopped == true)
            return this.ticks;
        if(this.started == false)
            return -1;
        return this.ticks;
    }

    public int getLapTime() {
        return this.ticks - this.thisLapTimeStart;
    }

    public int getLastLapTime() {
        return this.lastLapTime;
    }

    public void tick(int ticks) {
        this.ticks += ticks;
    }

    public void start() {
        this.started = true;
        this.thisLapTimeStart = this.ticks;
    }

    public void lap() {
        lastLapTime = this.ticks - this.thisLapTimeStart;
        this.thisLapTimeStart = this.ticks;
    }   
    
    public void stop() {
        this.hasBeenStopped = true;
        lap();
    }

    public static void main(String[] args) {
        
    }

    @Override
    public String toString() {
        return "";
    }
}
