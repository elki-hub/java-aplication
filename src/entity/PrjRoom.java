package entity;

public class PrjRoom extends Room {
    private int noOfPc;

    public PrjRoom (int noOfStud, int noRoom, int noOfPc) {
        super(noOfStud, noRoom);
        this.noOfPc = noOfPc;
    }

    public int getNoOfPc() {
        return noOfPc;
    }
    public void setNoOfPc(int noOfPc) {
        this.noOfPc = noOfPc;
    }

}
