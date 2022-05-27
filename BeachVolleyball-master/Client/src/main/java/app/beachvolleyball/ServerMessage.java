package app.beachvolleyball;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.io.Serializable;

@AllArgsConstructor
public class ServerMessage implements Serializable {

    static final long serialVersionUID = 999999000001L;

    @Getter
    @Setter
    private Point player1Position;

    @Getter
    @Setter
    private Point player2Position;

    @Getter
    @Setter
    private Point ballPosition;

    @Getter
    @Setter
    private String verifiedMessage;

    @Getter
    @Setter
    private int player1Score;

    @Getter
    @Setter
    private int player2Score;

    @Getter
    @Setter
    private byte connectedClients;

}