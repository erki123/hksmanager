package com.example.hksmanager.controller;

import com.example.hksmanager.component.Member;
import com.example.hksmanager.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    // Read all members
    @GetMapping("/all")
    public ResponseEntity<List<Member>> getAllMembers(){
        List<Member> members = memberService.findAllMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    // Find member by id
    @GetMapping("/find/{id}")
    public ResponseEntity<Member> getMemberByID(@PathVariable("id") Long id){
        Member member = memberService.findMemberById(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    // Add new member
    @PostMapping("/add")
    public ResponseEntity<Member> addMember(@RequestBody Member member){
        Member newMember = memberService.addMember(member);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED);
    }

    // Update member
    @PutMapping("/update")
    public ResponseEntity<Member> updateMember(@RequestBody Member member){
        Member updatedMember = memberService.updateMember(member);
        return new ResponseEntity<>(updatedMember, HttpStatus.OK);
    }

    // Delete member
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable("id") Long id){
        memberService.deleteMember(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
