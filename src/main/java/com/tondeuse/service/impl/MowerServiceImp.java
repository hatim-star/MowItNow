package com.tondeuse.service.impl;

import com.tondeuse.model.LawnMower;
import com.tondeuse.service.MowerService;
import org.springframework.stereotype.Service;

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
