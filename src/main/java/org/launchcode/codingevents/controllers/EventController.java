package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping()
    public String handler (Model model) {
        model.addAttribute("title", "List of Events");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event Form");
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@ModelAttribute Event newEvent) {
        EventData.add(newEvent);
        return "redirect:/events"; // instructs browser to go to a different page
    }

    // handler that displays form
    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events",EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String deleteEventFromForm(@RequestParam int id) {
        EventData.remove(id);
        return "redirect:/events";
    }

    @GetMapping("edit")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        return "events/edit/"+eventId;
    }

    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description) {
        return "events/edit";
    }
}
