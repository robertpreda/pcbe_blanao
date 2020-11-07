import java.util.Queue;
import java.lang.Math;
import java.util.concurrent.TimeUnit;
import java.time.LocalTime;


public class Client implements Runnable{
    private int id;
    private Queue queue;
    public Client(int id){
        this.id = id;
    }
    @Override
    public void run(){

        while(true){
            int rand = (int)(Math.random() * 3) + 1;
            Message msg = createMessage(rand, "Hello ");
            sendMsg(msg);

            LocalTime amu = LocalTime.now();

            Message msgRec = receiveMessage(msg);
            System.out.print("In client " + Integer.toString(id)+ ": " + msgRec.getText() + "from " + msg.getRec() + " at time: " + amu + " \n");

            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){

            }
        }


    }

    public Message createMessage(int receiverID, String text){
        Message msg = new Message(receiverID, text);

        return msg;
    }

    public synchronized void sendMsg(Message msg){
        Server.queue.add(msg);
        notify();
    }

    public Message receiveMessage(Message msg){
//        System.out.print("Got message: " + msg.getText());
        return msg;
    }
}
