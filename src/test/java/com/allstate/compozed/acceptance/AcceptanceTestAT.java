//package com.allstate.compozed.acceptance;
//
//import com.allstate.compozed.controller.SpacesController;
//import com.allstate.compozed.domain.Spaces;
//import com.allstate.compozed.repository.SpacesRepository;
//import org.fluentlenium.adapter.junit.FluentTest;
//import org.fluentlenium.core.hook.wait.Wait;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Iterator;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Wait
//public class AcceptanceTestAT extends FluentTest {
//    @Value("${local.server.port}")
//    private String port;
//
//    @Autowired
//    SpacesRepository spacesRepository;
//
////    @Test
//    public void testHomePage() {
//        goTo("http://localhost:" + this.port + "/");
//        assertThat($("#wired").text()).isEqualTo("Wired");
//    }
//
////    @Test
//    public void testInitialSpaceEmpty() {
//        Iterable<Spaces> iterable = spacesRepository.findAll();
//        Iterator<Spaces> iterator = iterable.iterator();
//
//        assertThat(iterator.hasNext()).isEqualTo(false);
//    }
//
////    @Test
//    public void testSpacesListEmptyForAddSpaceButton() {
//        goTo("http://localhost:" + this.port + "/");
//        assertThat($("#spacesList").text()).isEqualTo("");
//        assertThat($("#addSpaceButton").text()).isEqualTo("Add Space");
//    }
//
////    @Test
//    public void testAddSpaceButtonClicked() {
//        goTo("http://localhost:" + this.port + "/");
//        assertThat($("#createSpaceContainer").tagName()).isEqualTo("form");
//    }
//}