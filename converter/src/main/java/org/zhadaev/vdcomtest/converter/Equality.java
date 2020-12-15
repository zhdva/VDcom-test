package org.zhadaev.vdcomtest.converter;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Equality {

    private Double leftValue;
    private Unit leftUnit;
    private Double rightValue;
    private Unit rightUnit;

    private Equality(Builder builder) {
        this.leftValue = builder.leftValue;
        this.leftUnit = builder.leftUnit;
        this.rightValue = builder.rightValue;
        this.rightUnit = builder.rightUnit;
    }

    public Double getLeftValue() {
        return leftValue;
    }

    public void setLeftValue(Double leftValue) {
        this.leftValue = leftValue;
    }

    public Unit getLeftUnit() {
        return leftUnit;
    }

    public Double getRightValue() {
        return rightValue;
    }

    public void setRightValue(Double rightValue) {
        this.rightValue = rightValue;
    }

    public Unit getRightUnit() {
        return rightUnit;
    }

    @Override
    public String toString() {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#.##", decimalFormatSymbols);
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        String lValue = leftValue == null ? "?" : decimalFormat.format(leftValue);
        String rValue = rightValue == null ? "?" : decimalFormat.format(rightValue);
        return String.format("%s %s = %s %s", lValue, leftUnit.getName(), rValue, rightUnit.getName());
    }

    public static class Builder {
        private Double leftValue;
        private Unit leftUnit;
        private Double rightValue;
        private Unit rightUnit;

        public Builder leftValue(Double leftValue) {
            this.leftValue = leftValue;
            return this;
        }

        public Builder leftUnit(Unit leftUnit) {
            this.leftUnit = leftUnit;
            return this;
        }

        public Builder rightValue(Double rightValue) {
            this.rightValue = rightValue;
            return this;
        }

        public Builder rightUnit(Unit rightUnit) {
            this.rightUnit = rightUnit;
            return this;
        }

        public Equality build() {
            return new Equality(this);
        }
    }
}
