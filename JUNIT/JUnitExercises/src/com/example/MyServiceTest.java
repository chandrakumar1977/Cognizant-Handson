package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.InOrder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyServiceTest {

    @Test
    public void testExternalApi() {

        // Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);

       
        when(mockApi.getData()).thenReturn("Mock Data");

        
        MyService service = new MyService(mockApi);

       
        String result = service.fetchData();

       
        assertEquals("Mock Data", result);
    }
    @Test
    public void testVerifyInteraction() {

       
        ExternalApi mockApi = mock(ExternalApi.class);

        // Create service
        MyService service = new MyService(mockApi);

        // Call the method
        service.fetchData();      
        verify(mockApi).getData();
    }
    @Test
    public void testArgumentMatching() {

        //mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub 
        when(mockApi.getData(anyString())).thenReturn("Mockito");

        // service
        MyService service = new MyService(mockApi);

        String result = service.fetchData("Java");

        assertEquals("Mockito", result);
        verify(mockApi).getData(eq("Java"));
    }
    @Test
    public void testVoidMethod() {

    
        NotificationService mockNotification = mock(NotificationService.class);

        doNothing().when(mockNotification).sendNotification(anyString());
        MyService service = new MyService(mockNotification);
        service.notifyUser();
        verify(mockNotification).sendNotification("Welcome Chiranjeevee ");
    }
    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData())
                .thenReturn("First")
                .thenReturn("Second")
                .thenReturn("Third");
 
        MyService service = new MyService(mockApi);
        assertEquals("First", service.fetchData());
        assertEquals("Second", service.fetchData());
        assertEquals("Third", service.fetchData());
    }
    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.process();
        InOrder order = inOrder(mockApi);
        order.verify(mockApi).connect();
        order.verify(mockApi).getData();
        order.verify(mockApi).disconnect();
    }
    @Test
    public void testVoidMethodException() {

       
        NotificationService mockNotification = mock(NotificationService.class);

        doThrow(new RuntimeException("Notification Failed"))
                .when(mockNotification)
                .sendNotification(anyString());

        
        MyService service = new MyService(mockNotification);
        assertThrows(RuntimeException.class, () -> {
            service.notifyUser();
        });
        verify(mockNotification).sendNotification("Welcome");
    }
}




