import java.util.*;

public class Server implements Runnable{
    public static Queue<Message> queue;

    private Client c1, c2 ,c3;
    private HashMap<Integer, Client> map;


    public Server(Client c1, Client c2, Client c3){
        queue = new LinkedList<Message>();
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.map = new HashMap<>();

        map.put(1, c1);
        map.put(2, c2);
        map.put(3, c3);

    }

    @Override
    public void run(){
        while(true){
            handleMessages();
        }
    }

    public synchronized void handleMessages(){
        try{
            while(queue.size() == 0)
                wait();

        }catch(InterruptedException e){}

        Message gotMsg = queue.poll();
        int idToSend = gotMsg.getRec();

        Client c = map.get(idToSend);
        c.sendMsg(gotMsg);

    }
}
