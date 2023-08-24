package com.tondeuse.service.impl;

import com.tondeuse.model.MowerInput;
import com.tondeuse.model.Orientation;
import com.tondeuse.service.LawnMower;
import com.tondeuse.service.MowerService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MowerServiceImp implements MowerService {
    @Override
    public void processInstructions(LawnMower mower, String instructions) {
        for (char instruction : instructions.toCharArray()) {
            if (instruction == 'G') {
                mower.turnLeft();
            } else if (instruction == 'D') {
                mower.turnRight();
            } else if (instruction == 'A') {
                mower.move();
            }
        }
    }

}
