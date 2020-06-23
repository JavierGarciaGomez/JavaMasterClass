package S15Concurrency.l282LiveLockAndSlippedConditions;

public class Worker {
    private String name;
    private boolean active;

    public Worker(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public synchronized void work(SharedResource sharedResource, Worker otherWorker){
        while(active){
            if(sharedResource.getOwner() != this){
                try{
                    wait(100);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                continue;

            }
            if(otherWorker.isActive()){
                System.out.println(getName() + " : gibe the resource to the worker "+otherWorker.getName());
                sharedResource.setOwner(otherWorker);
                continue;
            }
            System.out.println(getName()+ ": working on the common resource");
            active=false;
            sharedResource.setOwner(otherWorker);
        }

    }
}
