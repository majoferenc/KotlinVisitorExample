package com.ibm.entity;

import com.ibm.visitor.Visitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;

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

    @Nullable
    @Override
    public Object accept(@NotNull Visitor visitor) {
        return visitor.visit(this);
    }
}
