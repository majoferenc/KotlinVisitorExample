package com.ibm.entity;

import com.ibm.visitor.Visitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ValueBlob implements Element {
    @Id
    @GeneratedValue
    private int valueBlobId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Nachricht nachricht;

    private String name;
    private String attachmentValue;

    public ValueBlob(){
        //default
    }

    @Nullable
    @Override
    public Object accept(@NotNull Visitor visitor) {
        return visitor.visit(this);
    }

    public ValueBlob(String name) {
        this.name = name;
    }

    public int getValueBlobId() {
        return valueBlobId;
    }

    public void setValueBlobId(int valueBlobId) {
        this.valueBlobId = valueBlobId;
    }

    public Nachricht getNachricht() {
        return nachricht;
    }

    public void setNachricht(Nachricht nachricht) {
        this.nachricht = nachricht;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueBlob valueBlob = (ValueBlob) o;
        return valueBlobId == valueBlob.valueBlobId &&
                Objects.equals(nachricht, valueBlob.nachricht) &&
                Objects.equals(name, valueBlob.name) &&
                Objects.equals(attachmentValue, valueBlob.attachmentValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueBlobId, nachricht, name, attachmentValue);
    }
}
