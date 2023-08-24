package com.tondeuse.controller;

import com.tondeuse.model.MowerInput;
import com.tondeuse.model.Orientation;
import com.tondeuse.service.MowerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MowerControllerTest {

    @InjectMocks
    private MowerController mowerController;

    @Mock
    private MowerService mowerService;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcess() {
        List<MowerInput> mowerInputs = new ArrayList<>();
        mowerInputs.add(new MowerInput(1, 2, Orientation.N, "GAGAGAGAA"));
        mowerInputs.add(new MowerInput(3, 3, Orientation.E, "AADAADADDA"));

        ResponseEntity<List<String>> response = mowerController.process(mowerInputs);

        response.getBody().forEach(System.out::println);
        assertEquals(200, response.getStatusCodeValue());
    }
}