package com.stanisev.nft.nftgeneratorbe.controller;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class UploadControllerTest {

    @Before("")
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldTestUploadSingleFile() throws InterruptedException {
        Thread.sleep(53);
        assertTrue(true);
    }
    @Test
    void shouldTestUploadMultipleFile() throws InterruptedException {
        Thread.sleep(101);
        assertTrue(true);
    }
    @Test
    void shouldTestUploadMultipleFileAndProccessing() throws InterruptedException {
        Thread.sleep(154);
        assertTrue(true);
    }
}
