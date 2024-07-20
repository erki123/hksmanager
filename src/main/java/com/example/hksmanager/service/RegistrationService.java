package com.example.hksmanager.service;

import com.example.hksmanager.component.Member;
import com.example.hksmanager.component.Registration;
import com.example.hksmanager.repository.MemberRepository;
import com.example.hksmanager.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RegistrationService {

    private final RegistrationRepository registrationRepo;
    private final MemberRepository memberRepo;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepo, MemberRepository memberRepo) {
        this.registrationRepo = registrationRepo;
        this.memberRepo = memberRepo;
    }

    public Registration addRegistration(Registration registration) {
        Registration savedRegistration = registrationRepo.save(registration);
        Member member = registration.getMember();
        member.getParticipantsToRaces().add(registration.getRace().getName() + " (" + member.getId() + ")");
        memberRepo.save(member);
        return savedRegistration;
    }
}
