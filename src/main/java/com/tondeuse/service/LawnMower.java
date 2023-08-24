package com.tondeuse.service;

import com.tondeuse.model.Orientation;
import com.tondeuse.model.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LawnMower {
    private Position position;
    private Orientation orientation;

    public LawnMower(int x, int y, Orientation orientation) {
        this.position = new Position(x, y);
        this.orientation = orientation;
    }

    public void turnLeft() {
        switch (orientation) {
            case N:
                orientation = Orientation.W;
                break;
            case E:
                orientation = Orientation.N;
                break;
            case S:
                orientation = Orientation.E;
                break;
            case W:
                orientation = Orientation.S;
                break;
        }
    }

    public void turnRight() {
        switch (orientation) {
            case N:
                orientation = Orientation.E;
                break;
            case E:
                orientation = Orientation.S;
                break;
            case S:
                orientation = Orientation.W;
                break;
            case W:
                orientation = Orientation.N;
                break;
        }
    }

    public void move() {
        switch (orientation) {
            case N:
                position.setY(position.getY() + 1);
                break;
            case E:
                position.setX(position.getX() + 1);
                break;
            case S:
                position.setY(position.getY() - 1);
                break;
            case W:
                position.setX(position.getX() - 1);
                break;
        }
    }

    public String getPositionAndOrientation() {
        return position.getX() + " " + position.getY() + " " + orientation;
    }

}

