package pl.sda.climbing_shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClimbingGearController {

    @GetMapping("/climbingGear")
    public String viewClimbingGear() {
        return "climbingGear";
    }

    @GetMapping("/climbingGear/shoes")
    public String viewClimbingShoes() {
        return "climbingShoes";
    }

    @GetMapping("/climbingGear/harnesses")
    public String viewHarnesses() {
        return "harnesses";
    }

    @GetMapping("/climbingGear/belay_rappel")
    public String viewBelayRappel() {
        return "belayRappel";
    }

    @GetMapping("/climbingGear/carabiners")
    public String viewCarabiners() {
        return "carabiners";
    }

    @GetMapping("/climbingGear/quickdraws")
    public String viewQuickdraws() {
        return "quickdraws";
    }

    @GetMapping("/climbingGear/ropes")
    public String viewRopes() {
        return "ropes";
    }

    @GetMapping("/climbingGear/helmets")
    public String viewHelmets() {
        return "helmets";
    }

}
