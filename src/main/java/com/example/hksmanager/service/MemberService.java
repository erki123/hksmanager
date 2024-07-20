package com.example.hksmanager.service;

import com.example.hksmanager.exception.UserNotFoundException;
import com.example.hksmanager.component.Member;
import com.example.hksmanager.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {

    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
    private final MemberRepository memberRepo;

    @Autowired
    public MemberService(MemberRepository memberRepo){
        this.memberRepo = memberRepo;
    }

    //Adding new member
    public Member addMember(Member member){
        logger.info("Adding new member: {}", member);
        return memberRepo.save(member);
    }

    //Finding all members
    public List<Member> findAllMembers(){
        logger.info("Fetching all members");
        return memberRepo.findAll();
    }

    //Updating member information
    public Member updateMember(Member member) {
        logger.info("Updating member with id {}", member.getId());
        Optional<Member> existingMemberOpt = memberRepo.findById(member.getId());
        if (existingMemberOpt.isPresent()) {
            Member existingMember = existingMemberOpt.get();
            logger.info("Before update: {}", existingMember);

            existingMember.setUsername(member.getUsername());
            existingMember.setEmail(member.getEmail());
            existingMember.setPassword(member.getPassword());
            existingMember.setMemberRole(member.getMemberRole());
            existingMember.setPhone(member.getPhone());
            existingMember.setParticipantsToRaces(member.getParticipantsToRaces());

            Member savedMember = memberRepo.save(existingMember);
            logger.info("After update: {}", savedMember);
            return savedMember;
        } else {
            throw new UserNotFoundException("User by id " + member.getId() + " not found");
        }
    }

    //Find member by id
    public Member findMemberById(Long id){
        logger.info("Fetching member with id {}", id);
        return memberRepo.findById(id).orElseThrow(
                () -> {
                    logger.error("User by id {} not found", id);
                    return new UserNotFoundException("User by id " + id + " not found");
                }
        );
    }

    //Delete member
    public void deleteMember(Long id) {
        logger.info("Attempting to delete member with id {}", id);
        if (!memberRepo.existsById(id)) {
            logger.error("User by id {} not found", id);
            throw new UserNotFoundException("User by id " + id + " not found");
        }
        memberRepo.deleteById(id);
        logger.info("Successfully deleted member with id {}", id);
    }
}
