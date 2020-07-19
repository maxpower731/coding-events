package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping()
    public String handler (Model model) {
        List events = new ArrayList<>();
        events.add("Conference1");
        events.add("Conference2");
        events.add("Conference3");
        events.add("Conference4");

        model.addAttribute("events", events);
        return "events/index";
    }

    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }
}
