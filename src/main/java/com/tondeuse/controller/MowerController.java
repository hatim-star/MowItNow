package com.tondeuse.controller;

import com.tondeuse.model.*;
import com.tondeuse.model.LawnMower;
import com.tondeuse.service.MowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mowers")
public class MowerController {

    private final MowerService mowerServiceFinal;

    @Autowired
    public MowerController(MowerService mowerServiceFinal) {
        this.mowerServiceFinal = mowerServiceFinal;
    }

    @PostMapping("/process")
    public ResponseEntity<List<String>> process(
            @RequestBody List<MowerInput> mowerInputs) {

        List<String> finalPositions = new ArrayList<>();
        for (MowerInput input : mowerInputs) {
            LawnMower mower = new LawnMower(input.getX(), input.getY(), input.getOrientation());
            mowerServiceFinal.processInstructions(mower, input.getInstructions());
            finalPositions.add(mower.getPositionAndOrientation());
        }

        return ResponseEntity.ok(finalPositions);
    }
}
