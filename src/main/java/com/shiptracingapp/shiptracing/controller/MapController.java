package com.shiptracingapp.shiptracing.controller;

import com.shiptracingapp.shiptracing.MonitorShips;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MapController {
    private final MonitorShips monitorShips;

    @GetMapping
    public String getMap(Model model) {
        model.addAttribute("area", monitorShips.mapArea());
        model.addAttribute("ships", monitorShips.mapShips());
        return "map";
    }
}
