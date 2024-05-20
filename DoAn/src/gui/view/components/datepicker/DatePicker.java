/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.view.components.datepicker;

import com.github.lgooddatepicker.components.DatePickerSettings;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Yuuta
 */
public class DatePicker extends com.github.lgooddatepicker.components.DatePicker {

    public DatePicker() {
        DatePickerSettings dateSettings = new DatePickerSettings();
        dateSettings.setFormatForDatesCommonEra(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        dateSettings.setFirstDayOfWeek(DayOfWeek.MONDAY);
        dateSettings.setAllowEmptyDates(false);
        dateSettings.setTranslationClear("Xóa");
        dateSettings.setTranslationToday("Hôm nay");
    }

}
