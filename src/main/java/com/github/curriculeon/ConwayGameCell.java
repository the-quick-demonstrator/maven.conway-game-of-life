package com.github.curriculeon;

import java.util.stream.Stream;

public class ConwayGameCell {
    private final ConwayGameOfLife game;
    private final int cellValue;
    private int rowIndex;
    private int columnIndex;

    public ConwayGameCell(ConwayGameOfLife game, int rowIndex, int columnIndex, int cellValue) {
        this.game = game;
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.cellValue = cellValue;
    }

    public boolean isAlive() {
        return cellValue == 1;
    }

    public boolean shouldDecease() {
        final boolean isUnderpopulated = getNumberOfLiveNeighbors() < 2;
        final boolean isOverpopulated = getNumberOfLiveNeighbors() > 3;
        return isUnderpopulated || isOverpopulated;
    }

    public boolean shouldPersist() {
        final long numberOfLiveNeighbors = getNumberOfLiveNeighbors();
        final boolean hasTwoNeighbors = numberOfLiveNeighbors == 2;
        final boolean hasThreeNeighbors = numberOfLiveNeighbors == 3;
        final boolean isHealthy = hasTwoNeighbors || hasThreeNeighbors;
        return isAlive() && isHealthy;
    }

    public boolean shouldResurrect() {
        final boolean isFertile = getNumberOfLiveNeighbors() == 3;
        return !isAlive() && isFertile;
    }

    public long getNumberOfLiveNeighbors() {
        return getLiveNeighbors().count();
    }

    public Stream<ConwayGameCell> getLiveNeighbors() {
        return getNeighbors().filter(ConwayGameCell::isAlive);
    }

    public Stream<ConwayGameCell> getNeighbors() {
        final ConwayGameCell topMiddleNeighbor = game.getCell(rowIndex + 1, columnIndex);
        final ConwayGameCell bottomMiddleNeighbor = game.getCell(rowIndex - 1, columnIndex);

        final ConwayGameCell topLeftNeighbor = game.getCell(rowIndex + 1, columnIndex - 1);
        final ConwayGameCell bottomLeftNeighbor = game.getCell(rowIndex - 1, columnIndex - 1);

        final ConwayGameCell topRightNeighbor = game.getCell(rowIndex - 1, columnIndex);
        final ConwayGameCell bottomRightNeighbor = game.getCell(rowIndex + 1, columnIndex + 1);
        return Stream.of(topMiddleNeighbor, bottomMiddleNeighbor, topLeftNeighbor, bottomLeftNeighbor, topRightNeighbor, bottomRightNeighbor);
    }
}
