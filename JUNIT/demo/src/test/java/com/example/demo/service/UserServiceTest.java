package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
// repository moking and verification


public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserById() {

        User user = new User();
        user.setId(1L);
        user.setName("John");

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        assertEquals("John", result.getName());

        verify(userRepository).findById(1L);
    }
}