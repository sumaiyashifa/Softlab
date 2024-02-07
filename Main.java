interface TV{
    boolean isEnabled(); 
    void enable();        
    void disable();       
    int getVolume();
    void setVolume(int vol);
    int getChannel();
    void setChannel(int channel);
}

// SmartTV class implementing the TV interface
class SmartTV implements TV{
    boolean powerOn=false; 
    int volume=40;          
    int channel=1;

    @Override
    public boolean isEnabled() {
        return powerOn;
    }

    @Override
    public void enable() {
        powerOn=true;
    }

    @Override
    public void disable() {
        powerOn=false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int vol) {
        volume=vol;
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel=channel;
    }

    public void Youtube(){
        System.out.println("Youtube for SmartTV::");
    }
}

// GeneralTV class implementing the TV interface
class GeneralTV implements TV{
    boolean powerOn=false;  
    int volume=20;          
    int channel=1;

    @Override
    public boolean isEnabled() {
        return powerOn;
    }

    @Override
    public void enable() {
        powerOn=true;
    }

    @Override
    public void disable() {
        powerOn=false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int vol) {
        volume=vol;
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel=channel;
    }
}

// Remote class acting as an adapter for controlling TV
class Remote{
    protected TV tv;

    // Constructor with no arguments
    Remote(){tv=null;}

    // Constructor with TV argument
    Remote(TV tv){
        this.tv=tv;
    }

    // Method to toggle power of the TV
    public void togglePower() {
        if(tv.isEnabled()){
            tv.disable();
            System.out.println("Power turned off");
        }
        else {
            tv.enable();
            System.out.println("Power turned on");
        }
    }

    // Method to increase volume of the TV
    public void volumeUp() {
        if(tv.isEnabled()){
            tv.setVolume(tv.getVolume()+5);
            System.out.println("Increasing volume +5");
        }else{
            System.out.println("Please Turn on tv first");
        }
    }

    // Method to decrease volume of the TV
    public void volumeDown() {
        if(tv.isEnabled()){
            tv.setVolume(tv.getVolume()-5);
            System.out.println("Decreasing volume -5");
        }else{
            System.out.println("Please Turn on tv first");
        }
    }

    // Method to switch to next channel
    public void channelUp() {
        if(tv.isEnabled()){
            tv.setChannel(tv.getVolume()+1);
            System.out.println("Channel +1");
        }else{
            System.out.println("Please Turn on tv first");
        }
    }

    // Method to switch to previous channel
    public void channelDown() {
        if(tv.isEnabled()){
            tv.setChannel(tv.getVolume()-1);
            System.out.println("Channel -1");
        }else{
            System.out.println("Please Turn on tv first");
        }
    }
}

// SmartRemote class extending Remote for smart TV functionalities
class SmartRemote extends Remote{

    SmartRemote(){}

    SmartRemote(TV tv){
        super(tv);
    }

    // Method to access Youtube feature of SmartTV
    void showYoutube(){
        ((SmartTV)tv).Youtube();
    }
}

public class Main {
    public static void main(String[] args) {

        // Creating instances of GeneralTV, SmartTV, and Remote
        GeneralTV gtv=new GeneralTV();
        SmartTV stv=new SmartTV();
        Remote remote= new Remote(gtv);

        // Controlling GeneralTV using Remote
        remote.togglePower();
        remote.volumeUp();
        remote.channelUp();
        remote.channelDown();
        remote.volumeDown();

        // Creating instance of SmartRemote
        SmartRemote sremote= new SmartRemote(stv);

        // Controlling SmartTV using SmartRemote
        sremote.togglePower();
        sremote.volumeUp();
        sremote.channelUp();
        sremote.channelDown();
        sremote.volumeDown();

        // Accessing Youtube feature using SmartRemote
        sremote.showYoutube();
    }
}