package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UniqueTextTest {
    @Test
    public void isEqual() {
        UniqueText uniqueText = new UniqueText();
        String origin = "My cat eats a mouse";
        String text = "My cat eats a mouse";
        assertThat(uniqueText.isEquals(origin, text)).isTrue();
    }

    @Test
    public void isNotEqual() {
        UniqueText uniqueText = new UniqueText();
        String origin = "My cat eats a mouse";
        String text = "A mouse is eaten by a cat";
        assertThat(uniqueText.isEquals(origin, text)).isFalse();
    }

    @Test
    public void isEqual2() {
        UniqueText uniqueText = new UniqueText();
        String origin = "My cat eats a mouse and milk";
        String text = "cat eats a mouse and";
        assertThat(uniqueText.isEquals(origin, text)).isTrue();
    }
}