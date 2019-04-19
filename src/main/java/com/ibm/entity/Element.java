package com.ibm.entity;

import com.ibm.visitor.Visitor;

public interface Element {
    Object accept(Visitor visitor);
}
