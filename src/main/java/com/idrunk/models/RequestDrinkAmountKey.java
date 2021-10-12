package com.idrunk.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RequestDrinkAmountKey implements Serializable {

    @Column(name = "request_id")
    private Long requestId;

    @Column(name = "drink_id")
    private Long drinkId;

    // constructor(s)
    public RequestDrinkAmountKey() {}
    public RequestDrinkAmountKey(long requestId, long drinkId) {
        this.requestId = requestId;
        this.drinkId = drinkId;
    }

    // getters and setters
    public Long getRequestId() {
        return requestId;
    }
    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }
    public Long getDrinkId() {
        return drinkId;
    }
    public void setDrinkId(Long drinkId) {
        this.drinkId = drinkId;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestDrinkAmountKey that = (RequestDrinkAmountKey) o;
        return requestId.equals(that.requestId) &&
                drinkId.equals(that.drinkId);
    }

    // hashcode
    @Override
    public int hashCode() {
        return Objects.hash(requestId, drinkId);
    }
}