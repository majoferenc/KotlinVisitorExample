package com.ibm;

import com.ibm.entity.Element;
import com.ibm.entity.Nachricht;
import com.ibm.entity.ValueBlob;
import com.ibm.helper.ListOfElements;
import com.ibm.visitor.ConcreteVisitorA;
import com.ibm.visitor.CountOfAttachmentVisitor;

public class Main {

    public static void main(String[] args) {
        ConcreteVisitorA visitorA = new ConcreteVisitorA();
        Nachricht nachricht1 = new Nachricht("HD123456");
        nachricht1.setNachrichtId(1);
        ValueBlob kba_attachment1 = new ValueBlob("kba1.xml");
        kba_attachment1.setNachrtId(1);
        ValueBlob nachricht_xml = new ValueBlob("nachricht.xml");
        nachricht_xml.setNachrtId(1);
        ValueBlob protocol_xml = new ValueBlob("protocol.xml");
        protocol_xml.setNachrtId(1);
        String xml1 = "xmlExample1";
        String xml2 = "xmlExample1";
        String xml3 = "xmlExample1";
        kba_attachment1.setAttachmentValue(xml1);
        nachricht_xml.setAttachmentValue(xml2);
        protocol_xml.setAttachmentValue(xml3);
        ListOfElements listA = new ListOfElements();
        listA.attach(nachricht1);
        listA.attach(kba_attachment1);
        listA.attach(nachricht_xml);
        listA.attach(protocol_xml);

        for (Element element: listA.getElementList()){
            element.accept(visitorA);
            Object elementReturn = element.accept(CountOfAttachmentVisitor.Companion);
            System.out.println("Element returned: " + elementReturn);
        }
    }
}