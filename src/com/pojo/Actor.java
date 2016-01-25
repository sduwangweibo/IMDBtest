package com.pojo;

public class Actor {
    private String actorId;

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    @Override
    public int hashCode() {
        return actorId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Actor)) {
            return false;
        }
        Actor actor = (Actor) obj;
        return this.actorId.equals(actor.getActorId());
    }

}
