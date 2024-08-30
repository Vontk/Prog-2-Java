package TP4;

public class Elevator {
    private final int minFloor;
    private final int maxFloor;
    private final int maxCapacity;
    private int currentFloor;
    private int currentCapacity;

    public Elevator(int minFloor, int maxFloor, int maxCapacity) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.maxCapacity = maxCapacity;
        this.currentFloor = minFloor;
        this.currentCapacity = 0;
    }
    public int getCurrentFloor() {
        return currentFloor;
    }
    public void moveToFloor(int callingFloor) {
        if (callingFloor <= maxFloor && callingFloor >= minFloor) {
            currentFloor = callingFloor;
        }
    }
    public int getPassengerCount() {
        return currentCapacity;
    }
    public void addPassenger(){
        if (currentCapacity < maxCapacity) {
            currentCapacity++;
        }
    }
    public void removePassenger(){
        if (currentCapacity > 0) {
            currentCapacity--;
        }
    }
}
