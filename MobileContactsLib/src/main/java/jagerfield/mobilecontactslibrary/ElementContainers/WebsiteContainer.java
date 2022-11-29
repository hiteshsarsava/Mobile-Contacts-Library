package jagerfield.mobilecontactslibrary.ElementContainers;

import android.database.Cursor;

import com.google.gson.annotations.Expose;

import java.util.HashSet;
import java.util.Set;

import jagerfield.mobilecontactslibrary.FieldElements.WebsiteElement.WebsiteElement;
import jagerfield.mobilecontactslibrary.Utilities.Utilities;

public class WebsiteContainer {
    @Expose
    private final WebsiteElement website;

    public WebsiteContainer(Cursor cursor) {
        website = new WebsiteElement(cursor);
    }

    public static Set<String> getFieldColumns() {
        Set<String> columns = new HashSet<>();
        columns.add(WebsiteElement.column);
        return columns;
    }

    public String getWebsite() {
        return Utilities.elementValue(website);
    }

}