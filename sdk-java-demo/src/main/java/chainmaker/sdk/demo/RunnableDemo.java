package chainmaker.sdk.demo;

class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;

    private int i;


    RunnableDemo( String name,int k) {
        threadName = name;
        i=k;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                    Contract.invokeContract(InitClient.chainClient);
                    Thread.sleep(1);
        }catch (Exception e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

