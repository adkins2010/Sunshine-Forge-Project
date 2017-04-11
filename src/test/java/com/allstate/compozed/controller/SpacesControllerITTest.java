//package com.allstate.compozed.controller;
//
//import com.allstate.compozed.domain.App;
//import com.allstate.compozed.domain.Spaces;
//import com.allstate.compozed.repository.SpacesRepository;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
//
//import static org.hamcrest.core.IsEqual.equalTo;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * Created by localadmin on 3/14/17.
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class SpacesControllerITTest {
//
//    @Autowired
//    SpacesRepository spacesRepository;
//
//    @Autowired
//    MockMvc mockMvc;
//
//
//    Spaces spaces;
//
////    @Before
//    public void setup() {
//        spaces = new Spaces();
//        spaces.setDisk_quotamb(120);
//        spaces.setMemory_quotamb(120);
//        spaces.setName("Larry");
//    }
//
////    @After
//    public void tearDown() {
//        spacesRepository.deleteAll();
//    }
//
////    @Test
//    @Transactional
//    @Rollback
//    public void testCreateSpace() throws Exception {
//        spaces.setName("Larry's Space");
//
//        MockHttpServletRequestBuilder request = post("/spaces")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"disk_quotamb\": 120,\"memory_quotamb\": 120, \"name\": \"Larry's Space\"}");
//
//        this.mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.disk_quotamb", equalTo(120)))
//                .andExpect(jsonPath("$.memory_quotamb", equalTo(120)))
//                .andExpect(jsonPath("$.name", equalTo("Larry's Space")));
//
//
//    }
//
////    @Test
//    @Transactional
//    @Rollback
//    public void testFindAllSpaces() throws Exception {
//
//        MockHttpServletRequestBuilder request = get("/spaces");
//
//
//        this.spacesRepository.save(spaces);
//        this.mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].disk_quotamb", equalTo(120)))
//                .andExpect(jsonPath("$[0].memory_quotamb", equalTo(120)))
//                .andExpect(jsonPath("$[0].name", equalTo("Larry")));
//    }
//
////    @Test
//    @Transactional
//    @Rollback
//    public void testFindOneSpace() throws Exception {
//        this.spacesRepository.save(spaces);
//
//        MockHttpServletRequestBuilder request = get("/spaces/" +spaces.getId());
//
//        this.mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.disk_quotamb", equalTo(120)))
//                .andExpect(jsonPath("$.memory_quotamb", equalTo(120)))
//                .andExpect(jsonPath("$.name", equalTo("Larry")));
//    }
//
//
////    @Test
//    @Transactional
//    @Rollback
//    public void testPutSpace() throws Exception {
//        spaces.setDisk_quotamb(240);
//        spaces.setMemory_quotamb(240);
//
//        spaces = spacesRepository.save(spaces);
//
//        MockHttpServletRequestBuilder request = put("/spaces/" + spaces.getId())
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"disk_quotamb\": 1000,\"memory_quotamb\": 1000, \"name\": \"Larry\"}");
//
//        this.mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.disk_quotamb", equalTo(1000)))
//                .andExpect(jsonPath("$.memory_quotamb", equalTo(1000)));
//
//    }
//
////    @Test
//    @Transactional
//    @Rollback
//    public void testDeleteSpace() throws Exception {
//
//        Spaces deleteSpace = this.spacesRepository.save(spaces);
//        MockHttpServletRequestBuilder request = delete("/spaces/" + deleteSpace.getId());
//
//
//        this.mockMvc.perform(request)
//                .andExpect(status().isNoContent());
//
//    }
//
//
//
//
//}
//
