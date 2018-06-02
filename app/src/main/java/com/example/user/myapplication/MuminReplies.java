package com.example.user.myapplication;

class MuminReplies {

    private String mobileNo;
    private int attendanceCount;

    @Override
    public String toString() {
        return "MuminReplies{" +
                "mobileNo=" + mobileNo +
                ", attendanceCount=" + attendanceCount +
                '}';
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(int attendanceCount) {
        this.attendanceCount = attendanceCount;
    }
}
