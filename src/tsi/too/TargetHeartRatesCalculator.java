package tsi.too;

import org.jetbrains.annotations.NotNull;
import tsi.too.model.HeartRates;
import tsi.too.util.InputDialog;
import tsi.too.util.MessageDialog;

import java.time.LocalDate;

import static tsi.too.Constants.*;

public class TargetHeartRatesCalculator {
    private HeartRates heartRates;

    public void readData() {
        String name = InputDialog.showStringInputDialog(USER_DATA, NAME, input -> !input.isEmpty());
        if (name == null)
            return;

        String surName = InputDialog.showStringInputDialog(USER_DATA, SURNAME, input -> !input.isEmpty());
        if (surName == null)
            return;

        LocalDate birthDate = InputDialog.showBrazilianDateInputDialog(
                USER_DATA,
                BIRTH_DATE_WITH_HINT,
                this::validateBirthDate
        );
        if (birthDate == null)
            return;

        heartRates = new HeartRates(name, surName, birthDate);
    }

    private boolean validateBirthDate(@NotNull LocalDate birthDate) {
        LocalDate minBirthDate = LocalDate.now().withYear(MIN_BIRTH_YEAR);

        return birthDate.isBefore(LocalDate.now()) && birthDate.isAfter(minBirthDate);
    }

    public void showResult() {
        if (heartRates == null) {
            MessageDialog.showAlertDialog(TARGET_HEART_HEARTS_CALCULATOR, NO_DATA_TO_SHOW);
            return;
        }

        MessageDialog.showInformationDialog(TARGET_HEART_HEARTS_CALCULATOR, buildMessage());
    }

    @NotNull
    private String buildMessage() {
        return String.format("%s: %s\n", NAME, heartRates.getName()) +
                String.format("%s: %s\n", AGE, heartRates.getAge()) +
                String.format("%s: %s\n", BIRTH_DATE, heartRates.getBirthDate()) +
                String.format("%s: %d %s\n", MAXIMUM_FREQUENCY, heartRates.getMaximumHeartRate(), BPM) +
                String.format("%s: %1.2f %s\n", MAX_TARGET_RATE, heartRates.getMaxTargetRate(), BPM) +
                String.format("%s: %1.2f %s\n", MIN_TARGET_RATE, heartRates.getMinTargetRate(), BPM)
                ;
    }
}