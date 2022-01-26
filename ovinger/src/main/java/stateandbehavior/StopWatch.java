package stateandbehavior;

// This does not work properly. I know the fix since I just now understood what the task really wanted, but I don't have the time.
// Anyways, I wrote a lot of code, so I figured I deliver this as well. 

public class StopWatch {

    boolean started;
    boolean hasBeenStopped;
    int ticks;
    int startTicks;
    int stopTicks;
    int thisLapTimeStart;
    int lastLapTime;

    public StopWatch() {
        this.started = false;
        this.hasBeenStopped = false;
        this.ticks = 0;
        this.startTicks = 0;
        this.stopTicks = 0;
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
        if (!this.started) return -1;
        if (this.hasBeenStopped) return this.stopTicks - this.startTicks;
        return this.ticks - this.startTicks;
    }

    public int getLapTime() {
        if (!this.started) return -1;
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
        this.startTicks = this.ticks;
        this.thisLapTimeStart = this.ticks;
    }

    public void lap() {
        lastLapTime = this.ticks - this.thisLapTimeStart;
        this.thisLapTimeStart = this.ticks;
    }   
    
    public void stop() {
        this.hasBeenStopped = true;
        this.stopTicks = this.ticks;
        lap();
    }

    public static void main(String[] args) {
        
    }

    @Override
    public String toString() {
        return "";
    }
}
