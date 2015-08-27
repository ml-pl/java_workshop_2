package org.workshop.framework;

@FunctionalInterface
public interface Scenario<In extends Page, Out extends Page> {
    Out run(In in);
}
