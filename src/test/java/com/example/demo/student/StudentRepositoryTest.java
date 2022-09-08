package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
//@SpringBootTest
@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void testSelectExistsEmailDoesExist() {
        // given
        String email = "jamila@gmail.com";
        Student student = new Student(
                "Jamila",
                email,
                Gender.FEMALE
        );
        underTest.save(student);

        // when
        boolean actual = underTest.selectExistsEmail(email);

        // then
        assertThat(actual).isTrue();
    }

    @Test
    void testSelectExistsEmailDoesNotExist() {
        // given
        String email = "jamila@gmail.com";

        // when
        boolean actual = underTest.selectExistsEmail(email);

        // then
        assertThat(actual).isFalse();
    }

}
