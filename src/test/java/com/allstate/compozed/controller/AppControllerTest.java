//package com.allstate.compozed.controller;
//
//import com.allstate.compozed.domain.App;
//import com.allstate.compozed.domain.Spaces;
//import com.allstate.compozed.repository.AppRepository;
//import com.allstate.compozed.repository.SpacesRepository;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
//
//import static org.hamcrest.core.IsEqual.equalTo;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//import java.util.ArrayList;
//
//
///**
// * Created by localadmin on 3/14/17.
// */
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class AppControllerTest {
//
//    @Autowired
//    AppRepository appRepository;
//
//    @Autowired
//    SpacesRepository spacesRepository;
//
//    @Autowired
//    MockMvc mockMvc;
//
//    Spaces space;
//
//    App app;
//
////    @Before
//    public void setup ()
//    {
//        spacesRepository.deleteAll();
//        appRepository.deleteAll();
//
//        space = new Spaces();
//
//        space.setDisk_quotamb(2000);
//        space.setMemory_quotamb(2000);
//        space.setName("Dana");
//
//
////        App app  = new App();
////        app.setName("Face Novel");
////        app.setDisk_allocationmb(1000);
////        app.setMemory_allocationmb(1000);
////        app.setSpace(space);
//
//        App app1  = new App();
//        app1.setName("Allstate GPS");
//        app1.setDisk_allocationmb(1000);
//        app1.setMemory_allocationmb(1000);
//        app1.setSpace(space);
//
//        space.setAppList(Arrays.asList(app1));
//
//        space = spacesRepository.save(space);
//        List<App> appList = Arrays.asList(appRepository.save(space.getAppList().get(0)));
//        space.setAppList(appList);
//
//    }
//
//
////    @After
//    public void tearDown() {
//        spacesRepository.deleteAll();
//        appRepository.deleteAll();
//    }
//
////    @Test
//        public void testCreateAppForSpace() throws Exception {
//
//       //spacesRepository.save(space);
//        MockHttpServletRequestBuilder request = post("/spaces/" + space.getId() + "/apps")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"name\": \"Face Novel\",\"disk_allocationmb\": 1000,\"memory_allocationmb\": 1000}");
//
//        this.mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name", equalTo("Face Novel")))
//                .andExpect(jsonPath("$.name", equalTo("Face Novel")))
//                .andExpect(jsonPath("$.name", equalTo("Face Novel")))
//                .andExpect(jsonPath("$.name", equalTo("Face Novel")))
//                .andExpect(jsonPath("$.name", equalTo("Face Novel")))
//                .andExpect(jsonPath("$.name", equalTo("Face Novel")));
//
//
//
//
//    }
//
//
//
////    @Test
//    public void testGetAllAppsInSpace() throws Exception
//    {
//
//        MockHttpServletRequestBuilder request;
//
//        request = get("/spaces/1/apps");
//
//        this.mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].disk_allocationmb", equalTo(1000)))
//                .andExpect(jsonPath("$[0].memory_allocationmb", equalTo(1000)))
//                .andExpect(jsonPath("$[0].name", equalTo("Allstate GPS")));
//
//
//        List<App> appList = StreamSupport.stream(appRepository.findAll().spliterator(),false).collect(Collectors.toList());
//
//        assertEquals("Testing the count of apps",1,appList.size());
//
//
//    }
//
////    @Test
//    public void testPutDetailsOfApp() throws Exception {
//        MockHttpServletRequestBuilder request = put("/spaces/" + space.getId() + "/apps/" + space.getAppList().get(0).getId())
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"name\": \"Face Novel\",\"disk_allocationmb\": 1000,\"memory_allocationmb\": 1000}");
//
//        this.mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name", equalTo("Allstate GPS")));
//    }
//
//
////    @Test
//    public void testDeleteApp() throws Exception
//    {
//        MockHttpServletRequestBuilder request = delete("/spaces/" + space.getId() + "/apps/" + space.getAppList().get(0).getId())
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"name\": \"Allstate GPS\",\"disk_allocationmb\": 1000,\"memory_allocationmb\": 1000}");
//
//        this.mockMvc.perform(request)
//                .andExpect(status().isOk());
//
//
//        assertNull("testing to make sure this was deleted",appRepository.findOne(space.getAppList().get(0).getId()));
//    }
//
//
////    @Test
//    public void testReturns403 () throws Exception
//
//    {
//        MockHttpServletRequestBuilder request = post("/spaces/"+ space.getId() + "/apps")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"name\": \"Larry's App\",\"disk_allocationmb\": 4000,\"memory_allocationmb\": 4000}");
//
//
//        this.mockMvc.perform(request)
//                .andExpect(status().isForbidden())
//                .andExpect(jsonPath("$[0].message",equalTo("You have exceeded your disk quota for app Larry's App")));
//
//
//    }
//}
