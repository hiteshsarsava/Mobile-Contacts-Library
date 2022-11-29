package jagerfield.mobilecontactslibrary.ElementContainers;

import android.database.Cursor;

import com.google.gson.annotations.Expose;

import java.util.HashSet;
import java.util.Set;

import jagerfield.mobilecontactslibrary.FieldElements.EventElements.EventLabelElement;
import jagerfield.mobilecontactslibrary.FieldElements.EventElements.EventStartDateElement;
import jagerfield.mobilecontactslibrary.FieldElements.EventElements.EventTypeElement;
import jagerfield.mobilecontactslibrary.Utilities.Utilities;

public class EventContainer {
    private final transient Cursor cursor;
    @Expose
    private final EventStartDateElement startDate;
    @Expose
    private final EventTypeElement eventType;
    @Expose
    private final EventLabelElement eventLable;

    public EventContainer(Cursor cursor) {
        this.cursor = cursor;
        startDate = new EventStartDateElement(cursor);
        eventType = new EventTypeElement(cursor);
        eventLable = new EventLabelElement(cursor);
    }

    public static Set<String> getFieldColumns() {
        Set<String> columns = new HashSet<>();
        columns.add(EventStartDateElement.column);
        columns.add(EventTypeElement.column);
        columns.add(EventLabelElement.column);
        return columns;
    }

    public String getEventStartDate() {
        return Utilities.elementValue(startDate);
    }

    public String getEventType() {
        return Utilities.elementValue(eventType);
    }

    public String getEventLabel() {
        return Utilities.elementValue(eventLable);
    }
}