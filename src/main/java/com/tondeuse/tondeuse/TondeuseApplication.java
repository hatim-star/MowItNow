package com.tondeuse.tondeuse;

import com.tondeuse.controller.MowerController;
import com.tondeuse.model.MowerInput;
import com.tondeuse.model.Orientation;
import com.tondeuse.service.impl.MowerServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class TondeuseApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(TondeuseApplication.class, args);

        List<MowerInput> mowerInputs = readInputFromFile("input.txt");
        MowerController mowerController = new MowerController(new MowerServiceImp());

        ResponseEntity<List<String>> response = mowerController.process(mowerInputs);

        if (response.getStatusCode() == HttpStatus.OK) {
            List<String> finalPositions = response.getBody();
            if (finalPositions != null) {
                for (String position : finalPositions) {
                    System.out.println(position);
                }
            }
        }
    }

    private static List<MowerInput> readInputFromFile(String filePath) throws IOException {
        List<MowerInput> mowerInputs = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(TondeuseApplication.class.getClassLoader().getResourceAsStream(filePath))));

        String lawnDimensions = reader.readLine();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] positionParts = line.split(" ");
            int x = Integer.parseInt(positionParts[0]);
            int y = Integer.parseInt(positionParts[1]);
            Orientation orientation = Orientation.valueOf(positionParts[2]);
            String instructions = reader.readLine();
            mowerInputs.add(new MowerInput(x, y, orientation, instructions));
        }

        reader.close();
        return mowerInputs;
    }
}
