package com.tondeuse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MowerInput {
    private int x;
    private int y;
    private Orientation orientation;
    private String instructions;

}

