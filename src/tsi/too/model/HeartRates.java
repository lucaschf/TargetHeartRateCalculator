package tsi.too.model;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class HeartRates {
    private String firstName;
    private String surName;

    private int birthYear;
    private int birthMonth;
    private int birthDay;

    public HeartRates(String firstName, String surName, int birthYear, int birthMonth, int birthDay) {
        this.firstName = firstName;
        this.surName = surName;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
    }

    public HeartRates(String firstName, String surName, @NotNull LocalDate birthDate) {
        this.firstName = firstName;
        this.surName = surName;
        this.birthYear = birthDate.getYear();
        this.birthMonth = birthDate.getMonthValue();
        this.birthDay = birthDate.getDayOfMonth();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public String getName() {
        return String.format("%s %s", firstName, surName);
    }

    public LocalDate getBirthDate() {
        return LocalDate.of(birthYear, birthMonth, birthDay);
    }

    public int getAge() {
        return Period.between(getBirthDate(), LocalDate.now()).getYears();
    }

    public int getMaximumHeartRate() {
        return 220 - getAge();
    }

    @NotNull
    public BigDecimal getMinTargetRate() {
        return BigDecimal.valueOf(0.6 * getMaximumHeartRate());
    }

    @NotNull
    public BigDecimal getMaxTargetRate() {
        return BigDecimal.valueOf(0.85 * getMaximumHeartRate());
    }

    @Override
    public String toString() {
        return "HeartRates{" +
                "name='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", birthYear=" + birthYear +
                ", birthMonth=" + birthMonth +
                ", birthDay=" + birthDay +
                '}';
    }
}
