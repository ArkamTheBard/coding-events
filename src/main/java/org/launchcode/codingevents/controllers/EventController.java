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

    private static Map<String, String> events = new HashMap<>();

    @GetMapping
    public String displayAllEvents(Model model){
        events.put("WWDC", "Apple World Wide Developer Conference");
        events.put("Developer Hour", "Remote code jam");
        events.put("All Hour of Code", "NWA one-hour introduction to comp=sci in schools");
        model.addAttribute("events", events);
        return "events/index";
    }

    @GetMapping("create") //lives at /events/create
    public String renderCreateEventForm() {
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@RequestParam String eventName, @RequestParam String eventDesc) {
        events.put(eventName, eventDesc);
        return "redirect:";
    }
}
