package com.university.management.service.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UtilTest {

    @Test
    public void utilNotNullNotEmptyTest() {
        assertThat(Util.CONSTANT_STATUS).isNotNull().isNotEmpty();
        assertThat(Util.CONSTANT_SUCCESS).isNotNull().isNotEmpty();
        assertThat(Util.CONSTANT_FAILED).isNotNull().isNotEmpty();
        assertThat(Util.CONSTANT_DATA).isNotNull().isNotEmpty();
        assertThat(Util.CONSTANT_MESSAGE).isNotNull().isNotEmpty();
    }
}
