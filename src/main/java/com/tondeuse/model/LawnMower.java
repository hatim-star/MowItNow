package com.tondeuse.model;

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
            case N -> orientation = Orientation.W;
            case E -> orientation = Orientation.N;
            case S -> orientation = Orientation.E;
            case W -> orientation = Orientation.S;
        }
    }

    public void turnRight() {
        switch (orientation) {
            case N -> orientation = Orientation.E;
            case E -> orientation = Orientation.S;
            case S -> orientation = Orientation.W;
            case W -> orientation = Orientation.N;
        }
    }

    public void move() {
        switch (orientation) {
            case N -> position.setY(position.getY() + 1);
            case E -> position.setX(position.getX() + 1);
            case S -> position.setY(position.getY() - 1);
            case W -> position.setX(position.getX() - 1);
        }
    }

    public String getPositionAndOrientation() {
        return position.getX() + " " + position.getY() + " " + orientation;
    }

}

