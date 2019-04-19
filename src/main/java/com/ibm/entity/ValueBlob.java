package com.ibm.entity;

import com.ibm.visitor.Visitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class ValueBlob implements Element {
    private int nachrtId;
    private String name;
    private String attachmentValue;

    public ValueBlob(String name) {
        this.name = name;
    }

    public int getNachrtId() {
        return nachrtId;
    }

    public void setNachrtId(int nachrtId) {
        this.nachrtId = nachrtId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttachmentValue() {
        return attachmentValue;
    }

    public void setAttachmentValue(String attachmentValue) {
        this.attachmentValue = attachmentValue;
    }

    public String getName() {
        return name;
    }

    @Nullable
    @Override
    public Object accept(@NotNull Visitor visitor) {
        return visitor.visit(this);
    }

}
