package com.utils;

public class TransactionStatus {
    private boolean status;
    private int changeIndex; //0 for reduce 1 for adding balance
    private boolean userFound=true;

    public boolean isUserFound() {
        return userFound;
    }

    public void setUserFound(boolean userFound) {
        this.userFound = userFound;
    }

    @Override
    public String toString() {
        return "TransactionStatus{" +
                "status=" + status +
                ", changeIndex=" + changeIndex +
                ", userFound=" + userFound +
                '}';
    }

    public TransactionStatus(boolean status, int changeIndex, boolean userFound) {
        this.userFound=userFound;
        this.status = status;
        this.changeIndex = changeIndex;
    }

    public TransactionStatus() {
    }

    public boolean isStatus() {

        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getChangeIndex() {
        return changeIndex;
    }

    public void setChangeIndex(int changeIndex) {
        this.changeIndex = changeIndex;
    }
}
