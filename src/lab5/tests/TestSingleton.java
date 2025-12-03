package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import lab5.*;

class TestSingleton {

    @Test
    void testSingletonReturnsSameInstance() {
        BorrowingService service1 = BorrowingService.getInstance();
        BorrowingService service2 = BorrowingService.getInstance();

        // Both should be the exact same object
        assertSame(service1, service2, "Two different Singleton instances detected");
    }

    @Test
    void testSingletonEquality() {
        BorrowingService service1 = BorrowingService.getInstance();
        BorrowingService service2 = BorrowingService.getInstance();

        // They should be equal
        assertEquals(service1, service2, "Singleton instances are not equal");
    }

    @Test
    void testSingletonNotNull() {
        BorrowingService service = BorrowingService.getInstance();

        assertNotNull(service, "Singleton instance should not be null");
    }
}