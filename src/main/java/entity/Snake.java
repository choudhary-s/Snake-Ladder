package entity;

public class Snake {
    int start;
    int end;

    public Snake(int start, int end) throws Exception{
        if(end>start){
            throw new Exception("Invalid snake");
        }
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
