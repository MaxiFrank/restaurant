package devmountain.group2.dtos;

public class GetAvailabilityDto {
    private Long id;
    private int tableId;

    private int capacity;

    private String timeSlot;
    private boolean hasReservation;

    private boolean hasConflict;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public boolean getHasReservation() {
        return hasReservation;
    }

    public void setHasReservation(boolean hasReservation) {
        this.hasReservation = hasReservation;
    }

    public boolean getHasConflict() {
        return this.hasConflict;
    }

    public void setHasConflict(boolean hasConflict) {
        this.hasConflict = hasConflict;
    }
}
