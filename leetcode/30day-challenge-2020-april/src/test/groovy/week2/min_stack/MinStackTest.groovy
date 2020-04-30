package week2.min_stack

import spock.lang.Specification

class MinStackTest extends Specification {

    def "Min Stack."() {
        when:
            def min = stack.getMin()
        then:
            min == expectedMin
        where:
            stack || expectedMin
            buildStack1() || -3
            buildStack2() || -2
            buildStack3() || -2
            buildStack4() || -2
    }

    def buildStack1() {
        MinStack minStack = new MinStack();
        minStack.push(-2)
        minStack.push(0)
        minStack.push(-3)
        return minStack
    }

    def buildStack2() {
        MinStack minStack = new MinStack();
        minStack.push(-2)
        minStack.push(0)
        minStack.push(-3)
        minStack.pop()
        minStack.top()
        return minStack
    }

    def buildStack3() {
        MinStack minStack = new MinStack();
        minStack.push(-2)
        minStack.push(0)
        minStack.push(-1)
        return minStack
    }

    def buildStack4() {
        MinStack minStack = new MinStack();
        minStack.push(-2)
        minStack.push(0)
        minStack.push(-1)
        minStack.top()
        minStack.pop()
        return minStack
    }
}
