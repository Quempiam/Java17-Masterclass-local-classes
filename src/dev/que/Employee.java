package dev.que;

public record Employee(
        String firstName,
        String lastName,
        int hireDate //year
){
    @Override
    public String toString() {
        return ("%-15s %-15s %d").formatted(firstName, lastName, hireDate);
    }
}
