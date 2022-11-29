package jagerfield.mobilecontactslibrary.ElementContainers;

import android.database.Cursor;

import com.google.gson.annotations.Expose;

import java.util.HashSet;
import java.util.Set;

import jagerfield.mobilecontactslibrary.FieldElements.EmailElements.EmailElement;
import jagerfield.mobilecontactslibrary.FieldElements.EmailElements.EmailLabelElement;
import jagerfield.mobilecontactslibrary.FieldElements.EmailElements.EmailTypeElement;
import jagerfield.mobilecontactslibrary.Utilities.Utilities;

public class EmailContainer {
    private final transient Cursor cursor;
    @Expose
    private final EmailElement email;
    @Expose
    private final EmailTypeElement emailType;
    @Expose
    private final EmailLabelElement emailLabel;

    public EmailContainer(Cursor cursor) {
        this.cursor = cursor;
        email = new EmailElement(cursor);
        emailType = new EmailTypeElement(cursor);
        emailLabel = new EmailLabelElement(cursor);
    }

    public static Set<String> getFieldColumns() {
        Set<String> columns = new HashSet<>();
        columns.add(EmailElement.column);
        columns.add(EmailTypeElement.column);
        columns.add(EmailLabelElement.column);
        return columns;
    }

    public String getEmail() {
        return Utilities.elementValue(email);
    }

    public String getEmailType() {
        return Utilities.elementValue(emailType);
    }

    public String getEmailLabel() {
        return Utilities.elementValue(emailLabel);
    }
}