//package com.fastcampus.sns.controller;
//
//import com.fastcampus.sns.controller.request.UserJoinRequest;
//import com.fastcampus.sns.controller.request.UserLoginRequest;
//import com.fastcampus.sns.exception.ErrorCode;
//import com.fastcampus.sns.exception.SnsApplicationException;
//import com.fastcampus.sns.service.UserService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//import static org.springframework.http.RequestEntity.post;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private UserService userService;
//
//    @Test
//    public void 회원가입() throws JsonProcessingException {
//        String userName = "userName";
//        String password = "password";
//
//        // TDDD : mocking
//        when(userService.join(userName, password)).thenReturn(mock(User.class));
//
//        mockMvc.perform(post("/api/v1/users/join")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    // TDD : add request body
//                    .content(objectMapper.writeValueAsBytes(new UserJoinRequest(userName, password)))
//                ).endDo(print())
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void 회원가입시_이미_회원가입된_userName으로_회원가입을_하는경우_에러반환(){
//        String userName = "userName";
//        String password = "password";
//
//        // TDDD : mocking
//        when(userService.join(userName, password)).thenThrow(new SnsApplicationException(ErrorCode.DUPLICATED_USER_NAME, ""));
//
//        mockMvc.perform(post("/api/v1/users/join")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        // TDD : add request body
//                        .content(objectMapper.writeValueAsBytes(new UserJoinRequest(userName, password)))
//                ).endDo(print())
//                .andExpect(status().isConflict());
//    }
//
//    @Test
//    public void 로그인() throws JsonProcessingException {
//        String userName = "userName";
//        String password = "password";
//
//        // TDDD : mocking
//        when(userService.login(userName, password)).thenReturn("test_token");
//
//        mockMvc.perform(post("/api/v1/users/login")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        // TDD : add request body
//                        .content(objectMapper.writeValueAsBytes(new UserLoginRequest(userName, password)))
//                ).endDo(print())
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void 로그인시_회원가입이_안된_userName을_입력할경우_에러반환() throws JsonProcessingException {
//        String userName = "userName";
//        String password = "password";
//
//        // TDDD : mocking
//        when(userService.login(userName, password)).thenThrow(new SnsApplicationException(ErrorCode.DUPLICATED_USER_NAME, ""));
//
//        mockMvc.perform(post("/api/v1/users/login")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        // TDD : add request body
//                        .content(objectMapper.writeValueAsBytes(new UserLoginRequest(userName, password)))
//                ).endDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    public void 로그인시_틀린_password를_입력할경우_에러반환() throws JsonProcessingException {
//        String userName = "userName";
//        String password = "password";
//
//        // TDDD : mocking
//        when(userService.login(userName, password)).thenThrow(new SnsApplicationException(ErrorCode.INVALID_PASSWORD));
//
//        mockMvc.perform(post("/api/v1/users/login")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        // TDD : add request body
//                        .content(objectMapper.writeValueAsBytes(new UserLoginRequest(userName, password)))
//                ).endDo(print())
//                .andExpect(status().isUnauthorized());
//    }
//
//}
