package app.beachvolleyball;

import app.beachvolleyball.ClientHandler;
import app.beachvolleyball.entity.Ball;
import app.beachvolleyball.entity.Net;
import app.beachvolleyball.entity.Player;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;
    private static final Player[] players = new Player[2];
    private static final Net net = new Net(SCREEN_WIDTH/2 - 10, SCREEN_HEIGHT/2);
    private static final Ball ball = new Ball((int)(0.25 * SCREEN_WIDTH - 50), 0);
    private static final List<String> swearWords = new ArrayList<>();

    public static void main(String[] args) throws IOException{

        players[0] = new Player((int)(0.25 * SCREEN_WIDTH - 50), SCREEN_HEIGHT - 100, 1);
        players[1] = new Player((int)(0.75 * SCREEN_WIDTH), SCREEN_HEIGHT - 100, 2);

        Scanner scanner = new Scanner(new File("src/main/resources/app/beachvolleyball/swear-words.txt"));

        while(scanner.hasNextLine())
            swearWords.add(scanner.nextLine());

        try (ServerSocket server = new ServerSocket(9797)) {

                int i=0;
                while(true) {
                    Socket socket = server.accept();
                    Thread thread = new Thread(new ClientHandler(socket, players, net, ball, i%2, "", swearWords));
                    thread.start();
                    i++;
                }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}