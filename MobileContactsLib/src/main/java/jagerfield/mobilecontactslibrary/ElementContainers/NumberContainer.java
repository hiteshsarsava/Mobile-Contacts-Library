package jagerfield.mobilecontactslibrary.ElementContainers;

import android.database.Cursor;

import com.google.gson.annotations.Expose;

import java.util.HashSet;
import java.util.Set;

import jagerfield.mobilecontactslibrary.FieldElements.NumberElements.LabelElement;
import jagerfield.mobilecontactslibrary.FieldElements.NumberElements.NormNumElement;
import jagerfield.mobilecontactslibrary.FieldElements.NumberElements.NumberElement;
import jagerfield.mobilecontactslibrary.FieldElements.NumberElements.NumberTypeElement;
import jagerfield.mobilecontactslibrary.Utilities.Utilities;

public class NumberContainer {
    @Expose
    private final NumberElement number;
    @Expose
    private final NormNumElement normalizedNumber;
    @Expose
    private final NumberTypeElement numType;
    @Expose
    private final LabelElement numLabel;

    public NumberContainer(Cursor cursor) {
        number = new NumberElement(cursor);
        normalizedNumber = new NormNumElement(cursor);
        numType = new NumberTypeElement(cursor);
        numLabel = new LabelElement(cursor);
    }

    public static Set<String> getFieldColumns() {
        Set<String> columns = new HashSet<>();
        columns.add(NumberElement.column);
        columns.add(NormNumElement.column);
        columns.add(NumberTypeElement.column);
        columns.add(LabelElement.column);
        return columns;
    }

    public String elementValue() {

        return Utilities.elementValue(number);
    }

    public String getNormalizedNumber() {

        return Utilities.elementValue(normalizedNumber);
    }

    public String getNumlabel() {

        return Utilities.elementValue(numLabel);
    }

    public String getNumType() {

        return Utilities.elementValue(numType);
    }


}