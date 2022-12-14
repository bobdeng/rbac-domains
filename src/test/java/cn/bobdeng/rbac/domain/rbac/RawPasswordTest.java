package cn.bobdeng.rbac.domain.rbac;

import cn.bobdeng.rbac.archtype.FieldIllegalException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RawPasswordTest {
    @ParameterizedTest
    @CsvSource(value = {
            "12345678",
            "123abcD",
            "1233abce",
            "abcdEfgi",
            "abcdE7g",
    })
    public void should_not_pass_weak(String password) {
        RawPassword rawPassword = new RawPassword(password);
        assertThrows(FieldIllegalException.class, () -> rawPassword.ensureStrength("weak"));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1234Abcd",
    })
    public void should_pass_weak(String password) {
        RawPassword rawPassword = new RawPassword(password);
        assertDoesNotThrow(() -> rawPassword.ensureStrength("weak"));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "12345678",
            "123abcD",
            "1233abce",
            "abcdEfgi",
            "abcdE7g$%",
    })
    public void should_not_pass_strong(String password) {
        RawPassword rawPassword = new RawPassword(password);
        assertThrows(FieldIllegalException.class, () -> rawPassword.ensureStrength("strong"));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "abcdE7g$%78",
    })
    public void should_pass_strong(String password) {
        RawPassword rawPassword = new RawPassword(password);
        assertDoesNotThrow(() -> rawPassword.ensureStrength("strong"));
    }

    @Test
    public void random_should_pass_strong() {
        RawPassword random = RawPassword.random();
        assertDoesNotThrow(() -> random.ensureStrength("strong"));
    }
}