package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < evenElements.size(); i++) {
            if (i % 2 == 0) {
                stringBuilder.append(evenElements.pollFirst());
                evenElements.addLast(null);
            } else {
                evenElements.pollFirst();
                evenElements.addLast(null);
            }
        }
        return stringBuilder.toString();
    }

    private String getDescendingElements() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < descendingElements.size(); i++) {
            stringBuilder.append(descendingElements.pollLast());
            descendingElements.addFirst(null);
        }
        return stringBuilder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}