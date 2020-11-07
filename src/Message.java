public class Message {

    private int rec;
    private String msg;

    public Message(int rec, String msg){
        this.rec = rec;
        this.msg = msg;
    }

    public int getRec(){
        return rec;
    }
    public String getText(){
        return msg;
    }
}
