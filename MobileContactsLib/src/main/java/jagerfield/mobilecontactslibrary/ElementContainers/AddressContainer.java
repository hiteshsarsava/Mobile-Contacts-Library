package jagerfield.mobilecontactslibrary.ElementContainers;

import android.database.Cursor;

import jagerfield.mobilecontactslibrary.FieldElements.AddressElement.AddressElement;
import jagerfield.mobilecontactslibrary.FieldElements.AddressElement.AddressTypeElement;
import jagerfield.mobilecontactslibrary.Utilities.Utilities;
import com.google.gson.annotations.Expose;
import java.util.HashSet;
import java.util.Set;

public class AddressContainer
{
    private final transient Cursor cursor;
    @Expose
    private final AddressElement address;
    @Expose
    private final AddressTypeElement addressType;

    public AddressContainer(Cursor cursor)
    {
        this.cursor = cursor;
        address = new AddressElement(cursor);
        addressType = new AddressTypeElement(cursor);
    }

    public static Set<String> getFieldColumns()
    {
        Set<String> columns = new HashSet<>();
        columns.add(AddressElement.column);
        return columns;
    }

    public String getAddress() {
        return Utilities.elementValue(address);
    }
    public String getAddressType()
    {
        return Utilities.elementValue(addressType);
    }

}