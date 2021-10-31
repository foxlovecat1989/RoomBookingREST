package com.virtualpairprogrammers.roombooking.rest;

import com.virtualpairprogrammers.roombooking.data.RoomRepository;
import com.virtualpairprogrammers.roombooking.model.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/rooms")
public class RestRoomsController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    Room getRoomById(@PathVariable("id") Long id){
        return roomRepository.findById(id).get();
    }

    @PostMapping
    Room newRoom(@RequestBody Room room){
        return roomRepository.save(room);
    }

    @PutMapping
    Room updateRoom(@RequestBody Room room){
        Room origin = roomRepository.findById(room.getId()).get();
        origin.setName(room.getName());
        origin.setLocation(room.getLocation());
        origin.setCapacities(room.getCapacities());

        return roomRepository.save(origin);
    }
}
