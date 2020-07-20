package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("events")
public class EventController {
    Map events = new HashMap<String, HashMap<String, String>>();

    @GetMapping()
    public String handler (Model model) {
        Map conference1 = new HashMap<String, String>();
        conference1.put("photo", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Yeon_Building_-_Portland%2C_Oregon.jpg/250px-Yeon_Building_-_Portland%2C_Oregon.jpg");
        conference1.put("description", "awesome conference");
        conference1.put("address", "123 Main St");
        events.put("Conference1", conference1);
        Map conference2 = new HashMap<String, String>();
        conference2.put("photo", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Vero_Centre_And_Other_Skyscrapers_I.jpg/220px-Vero_Centre_And_Other_Skyscrapers_I.jpg");
        conference2.put("description", "boring conference");
        conference2.put("address", "987 Main St");
        events.put("Conference2", conference2);
        Map conference3 = new HashMap<String, String>();
        conference3.put("photo", "https://i.ytimg.com/vi/nC5B-rVxjpw/hqdefault.jpg");
        conference3.put("description", "Another exciting conference");
        conference3.put("address", "5 Park Ave");
        events.put("Conference3", conference3);
        Map conference4 = new HashMap<String, String>();
        conference4.put("photo", "https://i.ytimg.com/vi/RKkJCRch6R0/hqdefault.jpg");
        conference4.put("description", "no one ever gets to this one");
        conference4.put("address", "One Coder Way");
        events.put("Conference4", conference4);

        model.addAttribute("events", events);
        return "events/index";
    }

    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm() {

        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventFormInputs(@RequestParam String eventName, @RequestParam String eventDescription, @RequestParam String eventAddress, @RequestParam String eventPhotoURL) {
        Map newConference = new HashMap<String, String>();
        newConference.put("description", eventDescription);
        newConference.put("photo", eventPhotoURL);
        newConference.put("address", eventAddress);
        events.put(eventName, newConference);

        return "redirect:/events";
    }
}
