
public class Main {

    public static void main(String[] args) {
        Client c1, c2, c3;

        c1 = new Client(1);
        c2 = new Client(2);
        c3 = new Client(3);

        Server srv = new Server(c1,c2,c3);

        Thread serverThread = new Thread(srv);

        Thread c1Th = new Thread(c1);
        Thread c2Th = new Thread(c2);
        Thread c3Th = new Thread(c3);

        serverThread.start();

        c1Th.start();
        c2Th.start();
        c3Th.start();

    }
}
