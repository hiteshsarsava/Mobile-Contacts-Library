package jagerfield.mobilecontactslibrary.ElementContainers;

import android.database.Cursor;

import com.google.gson.annotations.Expose;

import java.util.HashSet;
import java.util.Set;

import jagerfield.mobilecontactslibrary.FieldElements.NickNameElement.NickNameElement;
import jagerfield.mobilecontactslibrary.FieldElements.NickNameElement.NickNameTypeElement;
import jagerfield.mobilecontactslibrary.Utilities.Utilities;

public class NickNameContainer {
    private final transient Cursor cursor;
    @Expose
    private final NickNameElement nickName;
    @Expose
    private final NickNameTypeElement nickNameType;

    public NickNameContainer(Cursor cursor) {
        this.cursor = cursor;
        nickName = new NickNameElement(cursor);
        nickNameType = new NickNameTypeElement(cursor);
    }

    public static Set<String> getFieldColumns() {
        Set<String> columns = new HashSet<>();
        columns.add(NickNameElement.column);
        columns.add(NickNameTypeElement.column);
        return columns;
    }

    public String getNickName() {
        return Utilities.elementValue(nickName);
    }

    public String getNickNameType() {
        return Utilities.elementValue(nickNameType);
    }

}