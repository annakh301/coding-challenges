package com.mhp.coding.challenges.auth.inbound;

import com.mhp.coding.challenges.auth.core.entities.Door;
import com.mhp.coding.challenges.auth.core.inbound.DoorProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class DoorController {

    private final DoorProvider doorProvider;

    public DoorController(DoorProvider doorProvider) {
        this.doorProvider = doorProvider;
    }
    
    @GetMapping("/v1/doors")
    @ResponseBody
    public ResponseEntity<List<Door>> listDoors() {
        return ResponseEntity.ok(this.doorProvider.triggerDoorListing());
    }

    @PutMapping("/v1/doors/{id}")
    public ResponseEntity changeDoorState(@RequestBody Door door, @PathVariable Long id) {
        Door newDoor = this.doorProvider.triggerDoorStateChange(door);
        return newDoor == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(newDoor);
    }

}
