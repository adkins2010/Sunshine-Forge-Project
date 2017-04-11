//package com.allstate.compozed.controller;
//
//import com.allstate.compozed.domain.Spaces;
//import com.allstate.compozed.repository.SpacesRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import java.util.Collections;
//import static org.hamcrest.core.IsEqual.equalTo;
//import static org.mockito.Matchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * Created by localadmin on 3/14/17.
// */
//@RunWith(SpringRunner.class)
//@WebMvcTest(SpacesController.class)
//public class SpacesControllerTest {
//
//    @MockBean
//    SpacesRepository spacesRepository;
//
//    @Autowired
//    MockMvc mockMvc;
//
//
//    Spaces spaces ;
//
////    @Before
//    public void setup (){
//        spaces = new Spaces();
//        spaces.setDisk_quotamb(120);
//        spaces.setMemory_quotamb(120);
//        spaces.setName("Larry");
//    }
////    @Test
//    public void testCreateSpace() throws Exception
//    {
//        spaces.setName("Larry's Space");
//
//        MockHttpServletRequestBuilder request = post("/spaces/addspace")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"disk_quotamb\": 120,\"memory_quotamb\": 120, \"name\": \"Larry's Space\"}");
//
//        this.mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.disk_quotamb", equalTo(120)))
//                .andExpect(jsonPath("$.memory_quotamb", equalTo(120)))
//                .andExpect(jsonPath("$.name", equalTo("Larry's Space")));
//
//        verify(this.spacesRepository).save(any(Spaces.class));
//
//    }
//
////    @Test
//    public void testFindAllSpaces() throws Exception
//    {
//
//
//        when(this.spacesRepository.findAll()).thenReturn(Collections.singletonList(spaces));
//
//        MockHttpServletRequestBuilder request = get("/spaces/findallspaces");
//
//        this.mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].disk_quotamb", equalTo(120)))
//                .andExpect(jsonPath("$[0].memory_quotamb", equalTo(120)))
//                .andExpect(jsonPath("$[0].name", equalTo("Larry")));
//
//        verify(this.spacesRepository).findAll();
//
//    }
//
////    @Test
//    public void testFindOneSpace() throws Exception {
//
//        when(this.spacesRepository.findOne(7l)).thenReturn(spaces);
//
//        MockHttpServletRequestBuilder request = get("/spaces/7");
//
//        this.mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.disk_quotamb", equalTo(120)))
//                .andExpect(jsonPath("$.memory_quotamb", equalTo(120)))
//                .andExpect(jsonPath("$.name", equalTo("Larry")));
//    }
//
//
//    //These last two tests are examples of pointless tests and would be better served
//    //as integration tests since we need to reach out to the database to verify anything
//    //actually happens
//
////    @Test
//    public void testPutSpace() throws Exception
//    {
//        spaces =spacesRepository.save(spaces);
//        MockHttpServletRequestBuilder request = put("/spaces/updatespace/" + spaces.getId())
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"disk_quotamb\": 240,\"memory_quotamb\": 240, \"name\": \"Larry\"}");
//
//        this.mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.disk_quotamb", equalTo(240)))
//                .andExpect(jsonPath("$.memory_quotamb", equalTo(240)));
//
//        verify(this.spacesRepository).save(any(Spaces.class));
//    }
//
////    @Test
//    public void testDeleteSpace() throws Exception {
//
//        MockHttpServletRequestBuilder request = delete("/spaces/7");
//
//        this.mockMvc.perform(request)
//                .andExpect(status().isNoContent());
//
//        verify(this.spacesRepository).delete(7l);
//
//    }
//
//}
