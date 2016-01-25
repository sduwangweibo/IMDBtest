package com.pojo;

public class Director {
    private String directorId;

    public String getDirectorId() {
        return directorId;
    }

    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }

    @Override
    public int hashCode() {
        return directorId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Director)) {
            return false;
        }
        Director director = (Director) obj;
        return this.directorId.equals(director.getDirectorId());
    }

}
