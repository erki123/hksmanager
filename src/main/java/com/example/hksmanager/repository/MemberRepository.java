package com.example.hksmanager.repository;
import com.example.hksmanager.component.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findById(Long id);

}
