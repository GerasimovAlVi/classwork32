package ru.innopolis.jms.request;

public class ItemRequest {
    private String mode;
    private int id;

    public ItemRequest(String mode, int id) {
        this.mode = mode;
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ItemRequest{" +
                "mode='" + mode + '\'' +
                ", id=" + id +
                '}';
    }
}
