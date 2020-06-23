package S09InnerAbstractClassInterfacesL122_134.L122_125Interfaces;

public class MobilePhone implements ITelephone {

    private int myNumber;
    private boolean isRinging;
    private boolean isOn=false;

    public MobilePhone() {
    }

    @Override
    public void powerOn() {
        isOn=true;
        System.out.println("Movile Phone powered up.");
    }

    @Override
    public void dial(int phoneNumber) {
        if(isOn){
            System.out.println("Now ringing "+ phoneNumber+" on mobile Phone");
        } else{
            System.out.println("Phone is off");
        }
    }

    @Override
    public void answer() {
        if(isRinging){
            System.out.println("Answering the "+getClass().getName());
            isRinging=false;
        }

    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(phoneNumber == myNumber & isOn){
            isRinging=true;
            System.out.println("Phone number Melody ring");
        } else{
            isRinging=false;
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
