package ma.sqli.tests.cloudinfrastructure;

public class CloudMachine {
    private String name;
    private String operatingSystem;
    private String diskSize;
    private String memory;
    private MachineState state;

    public CloudMachine(String name, String operatingSystem, String diskSize, String memory) {
        this.name = name;
        this.operatingSystem = operatingSystem;
        this.diskSize = diskSize;
        this.memory = memory;
        this.state = new MachineStateInactive();
    }

    public String getName() {
        return name;
    }

    public void setState(MachineState state) {
        this.state = state;
    }

    public String printMachine(){
        String machineDescription ;

        machineDescription = name + ":" +state.print();

        return machineDescription;
    }

    public void goInactive(){
        this.state.goInactive(this);
    }

    public void goRunning(){
        this.state.goRunning(this);
    }

    public void goStopped(){
        this.state.goStopped(this);
    }


    public double usedDisk() {
        return Double.valueOf(diskSize.substring(0,diskSize.length()-2));
    }

    public boolean isRunning() {
        return this.state instanceof MachineStateRunning;
    }

    public double usedMemory() {
        return Double.valueOf(memory.substring(0,memory.length()-2));
    }
}
