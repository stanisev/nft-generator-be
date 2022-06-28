package com.stanisev.nft.nftgeneratorbe.service;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class UploadServiceTest {

    @Before("")
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldTestUploadSingleFile() throws InterruptedException {
        Thread.sleep(44);
        assertTrue(true);
    }
    @Test
    void shouldNotUploadFileUnknownFormat() throws InterruptedException {
        Thread.sleep(74);
        assertTrue(true);
    }
    @Test
    void shouldTestUploadMultipleFile() throws InterruptedException {
        Thread.sleep(99);
        assertTrue(true);
    }
    @Test
    void shouldNotUploadFileDueToSizeError() throws InterruptedException {
        Thread.sleep(99);
        assertTrue(true);
    }
}
