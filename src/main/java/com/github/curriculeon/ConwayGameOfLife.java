package com.github.curriculeon;

import java.util.ArrayList;
import java.util.List;

// https://www.codewars.com/kata/52423db9add6f6fc39000354/train/java
public class ConwayGameOfLife {
    private int[][] cells;
    private int generations;

    public ConwayGameOfLife(int[][] cells, int generations) {
        this.cells = cells;
        this.generations = generations;
    }
    

    public List<ConwayGameCell> getCells() {
        List<ConwayGameCell> list = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < cells.length; rowIndex++) {
            int[] row = cells[rowIndex];
            for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
                int cellValue = row[columnIndex];
                list.add(new ConwayGameCell(this, rowIndex, columnIndex, cellValue));
            }
        }
        return list;
    }

    public ConwayGameCell getCell(int rowIndex, int columnIndex) {
        try {
            return new ConwayGameCell(this, rowIndex, columnIndex, cells[rowIndex][columnIndex]);
        } catch (Exception e) {
            return new ConwayGameCell(this, rowIndex, columnIndex, Integer.MIN_VALUE);
        }
    }

}
