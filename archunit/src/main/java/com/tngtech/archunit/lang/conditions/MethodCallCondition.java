package com.tngtech.archunit.lang.conditions;

import com.tngtech.archunit.core.DescribedPredicate;
import com.tngtech.archunit.core.JavaCall;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvent;
import com.tngtech.archunit.lang.ConditionEvents;

class MethodCallCondition extends ArchCondition<JavaCall<?>> {
    private final DescribedPredicate<? super JavaCall<?>> callIdentifier;

    MethodCallCondition(DescribedPredicate<? super JavaCall<?>> callIdentifier) {
        super("call method where " + callIdentifier.getDescription());
        this.callIdentifier = callIdentifier;
    }

    @Override
    public void check(JavaCall<?> item, ConditionEvents events) {
        events.add(new ConditionEvent(callIdentifier.apply(item), item.getDescription()));
    }
}