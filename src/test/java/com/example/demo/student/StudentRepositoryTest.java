package com.example.demo.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @Test
    void testSelectExistsEmail() {
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
}
