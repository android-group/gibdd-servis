package ru.android_studio.gibdd_servis.auto.model.history;

import java.util.List;

import ru.android_studio.gibdd_servis.auto.model.ResultAuto;

/**
 * Created by yuryandreev on 20/09/16.
 */
public class ResultAutoHistory extends ResultAuto {
    private Vehicle vehicle;
    private List<OwnershipPeriod> ownershipPeriodList;
    private String message;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public List<OwnershipPeriod> getOwnershipPeriodList() {
        return ownershipPeriodList;
    }

    public void setOwnershipPeriodList(List<OwnershipPeriod> ownershipPeriodList) {
        this.ownershipPeriodList = ownershipPeriodList;
    }

    @Override
    public String toString() {
        return "ResultAutoHistory{" +
                "response='" + response + '\'' +
                ", type=" + type +
                ", vehicle=" + vehicle +
                ", ownershipPeriodList=" + ownershipPeriodList +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultAutoHistory that = (ResultAutoHistory) o;

        if (response != null ? !response.equals(that.response) : that.response != null)
            return false;
        if (type != that.type) return false;
        if (vehicle != null ? !vehicle.equals(that.vehicle) : that.vehicle != null) return false;
        if (ownershipPeriodList != null ? !ownershipPeriodList.equals(that.ownershipPeriodList) : that.ownershipPeriodList != null)
            return false;
        return message != null ? message.equals(that.message) : that.message == null;

    }

    @Override
    public int hashCode() {
        int result = response != null ? response.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (vehicle != null ? vehicle.hashCode() : 0);
        result = 31 * result + (ownershipPeriodList != null ? ownershipPeriodList.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}
